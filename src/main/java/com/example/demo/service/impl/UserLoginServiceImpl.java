package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserLoginService;
import com.example.demo.util.HashUtil;

@Service
public class UserLoginServiceImpl implements UserLoginService {
	
	@Autowired UserRepository userRepository;
	
	@Autowired UserMapper userMapper;
	
	@Override
	public UserDTO login(String userName, String password, String authCode, String sessionAuthCode) {
	
		// 1. 比對驗證碼
		if(!authCode.equals(sessionAuthCode)) {
			throw new RuntimeException("驗證碼不符");
		}
		
		// 2. 比對有無使用者
        List<User> users = userRepository.findUserByName(userName);
        User user = users.isEmpty() ? null : users.get(0);
        if(user == null) {
			throw new RuntimeException("查無使用者");
		}
        
		// 3. email 是否驗證通過
		boolean completed = user.getCompleted();
		if(!completed) {
			throw new RuntimeException("Email 尚無驗證通過");
		}
		// 4. 驗證密碼
		try {
			String hashPassword = HashUtil.hashPassword(password, user.getHashSalt());
			boolean checkPassword = user.getHashPassword().equals(hashPassword);
			if(!checkPassword) {
				throw new RuntimeException("密碼錯誤");
			}
            // 5. 回傳 DTO
            UserDTO userDTO = userMapper.toDTO(user);
			return userDTO;
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
		
	}
}