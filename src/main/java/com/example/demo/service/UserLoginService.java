package com.example.demo.service;

import com.example.demo.model.dto.UserDTO;

public interface UserLoginService {
	UserDTO login(String userName, String password, String authCode, String sessionAuthCode);
}
