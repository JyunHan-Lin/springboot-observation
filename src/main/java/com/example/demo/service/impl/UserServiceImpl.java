package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserLoginRepository;
import com.example.demo.service.UserService;
import com.example.demo.util.HashUtil;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserLoginRepository userRepository;
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDTO getUser(String username) {
		User user = userRepository.getUser(username);
		if(user == null) {
			return null;
		}
		return userMapper.toDTO(user);
	}
	
	@Override
	public UserDTO login(String username, String password, String inputCode, String sessionCode) {
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

	    return userMapper.toDTO(user);
	}


	@Override
	public void addUser(String username, String password, String email, Boolean active, String role) {
		String salt = HashUtil.getSalt();
		String passwordHash = HashUtil.getHash(password, salt);
		User user = new User(null, username, passwordHash, salt, email, active, role);
		userRepository.save(user);
	}
}