package com.example.demo.service;

import com.example.demo.model.dto.UserDTO;

public interface UserService {
	public UserDTO getUser(String username);
	public UserDTO login(String username, String password, String inputCode, String sessionCode);
	public void addUser(String username, String password, String email, Boolean active, String role);
	// 往下自訂...(CRUD)
}