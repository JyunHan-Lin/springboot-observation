package com.example.demo.service;

import com.example.demo.model.dto.UserDTO;

public interface UserLoginService {
	// 驗證是否登入成功
	// username, password, authcode = 登入三劍客(使用者所自行輸入的資訊)
	// sessionAuthCode = 目前存在 session 驗證碼
	UserDTO login(String username, String password, String authcode, String sessionAuthCode);
}
