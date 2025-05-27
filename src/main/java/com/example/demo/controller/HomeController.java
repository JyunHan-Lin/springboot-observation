package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bbd")
public class HomeController {

	@Autowired
    private UserService userService;
	
	@GetMapping
	public String mainPage() {
		return "main";
	}
	// 進入討論區
	@GetMapping("/discuss")
	public String discussPage() {
		return "discuss/discuss";
	}
	// 進入行為分析區
	@GetMapping("/behavior")
	public String behaviorPage() {
		return "behavior/behavior";
	}
	
	// 密碼變更
	@GetMapping("/codeedit")
	public String codeEditPage() {
		return "member";
	}
	
	// 網頁個人化
	@GetMapping("/pageeedit")
	public String pageEdit() {
		return "pagesetup";
	}
	
	// 登出
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login"; 
	}
	
}
