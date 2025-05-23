package com.example.demo.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRegisterRepository;
import com.example.demo.service.UserRegisterService;
import com.example.demo.util.HashUtil;

@Service
public class UserRegisterServiceImpl implements UserRegisterService {

	@Autowired
	private UserRegisterRepository userRegisterRepository;
	
	@Override
	public void addUser(String username, String password, String email) {
	    // 判斷使用者是否已存在
	    if (userRegisterRepository.existsByUsername(username)) {
	        System.out.println("使用者已經註冊過了");
	        return;
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
		
		userRegisterRepository.save(user);
		System.out.println("使用者註冊成功");
	}
}
