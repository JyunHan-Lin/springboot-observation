package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDTO getUser(String username, String password, String inputCode, String sessionCode) {
	    if (!inputCode.equalsIgnoreCase(sessionCode)) {
	        throw new RuntimeException("驗證碼不正確");
	    }

	    User user = userRepository.getUser(username);
	    if (user == null) {
	        throw new RuntimeException("帳號不存在");
	    }

	    String hash = HashUtil.getHash(password, user.getSalt());
	    if (!hash.equals(user.getPasswordHash())) {
	        throw new RuntimeException("密碼錯誤");
	    }
	    
	    if (!user.getActive()) {
	        throw new RuntimeException("帳號尚未啟用，請先完成 Email 驗證");
	    }
	    
	    return userMapper.toDTO(user);
	}


	@Override
	public void addUser(String username, String password, String email) {
	    // 判斷使用者是否已存在
	    if (userRepository.existsByUsername(username)) {
	    	throw new RuntimeException("使用者已經註冊過了");
	    }
		String salt = HashUtil.getSalt();
		String passwordHash = HashUtil.getHash(password, salt);
		
		User user = new User();
			 user.setUsername(username);
			 user.setPasswordHash(passwordHash);
			 user.setSalt(salt);
			 user.setEmail(email);
			 user.setActive(false); 
			 user.setRole("user"); 
		
		userRepository.save(user);
		System.out.println("使用者註冊成功");
		
	}
	
	public boolean confirmEmail(String username) {
	    Optional<User> optUser = userRepository.findByUsername(username);
	    if (optUser.isPresent()) {
	        User user = optUser.get();
	        // 假設 User 類別有一個表示認證狀態的欄位，例如 emailConfirmed
	        user.setActive(true);  // 將認證狀態設為 true
	        userRepository.save(user); // 儲存更新後的使用者
	        return true;
	    } else {
	        return false;
	    }
	}
}