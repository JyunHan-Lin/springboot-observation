package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.exception.PasswordInvalidException;
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

	// 註冊
	// 參數待改 ?
	@Override
	public void addUser(String username, String password, String email, Boolean active, String role) {
	    // 判斷使用者是否已存在
	    if (userRepository.existsByUsername(username)) {
	    	throw new RuntimeException("使用者已經註冊過了");
	    }
		String salt = HashUtil.getSalt();
		String passwordHash = HashUtil.getHash(password, salt);
		User user = new User(null, username, passwordHash, salt, email, active, role, null);
		userRepository.save(user);
		System.out.println("使用者註冊成功");
		
	}
	
	// email
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
	
	// 改密碼
	public boolean changePassword(String email, String oldPassword, String newPassword, String confirmPassword) {
        Optional<User> optUser = userRepository.findByEmail(email);

        if (optUser.isEmpty()) 
        	return false;

        User user = optUser.get();

        // 檢查舊密碼是否正確
        String passwordHash = HashUtil.getHash(oldPassword, user.getSalt());
		if(!passwordHash.equals(user.getPasswordHash())) {
			throw new RuntimeException("原本密碼輸入錯誤");
		}
		
		// 檢查新密碼是否與舊密碼重複
		String confirmedPassword = HashUtil.getHash(newPassword, user.getSalt());
        if (!confirmedPassword.equals(passwordHash)) {
    		throw new RuntimeException("新密碼不可與舊密碼重複");
        }
        // 檢查新密碼與確認是否相同
		String checkedPassword = HashUtil.getHash(confirmPassword, user.getSalt());
        if (!checkedPassword.equals(confirmedPassword)) {
			throw new RuntimeException("新密碼不可與舊密碼重複");
        }

        user.setPasswordHash(checkedPassword);
        userRepository.save(user);
        return true;
	}
}