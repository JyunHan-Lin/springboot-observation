package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import com.example.demo.util.HashUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public String registerPage() {
		return "register";
	}
	
	@PostMapping
	public String addUser(@RequestParam String username,
	                      @RequestParam String password,
	                      @RequestParam String email,
	                      Model model) {

		// 呼叫 service 儲存用戶資料
	    userService.addUser(username, password, email, false, "user");

	    // 寄送 email 驗證信
	    String emailConfirmLink = "http://localhost:8085/email/confirm?username=" + username;
	    emailService.sendEmail(email, emailConfirmLink);

	    // 顯示結果
	    String resultTitle = "註冊結果";
	    String resultMessage = "用戶 " + username + " 註冊成功!<p />系統已送出驗證信件到 " + email + " 信箱, 請收信並點選[確認]連結";

	    model.addAttribute("resultTitle", resultTitle);
	    model.addAttribute("resultMessage", resultMessage);

	    return "result";
	}
}

