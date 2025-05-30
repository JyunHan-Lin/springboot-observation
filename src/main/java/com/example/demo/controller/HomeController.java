package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.DiscussService;
import com.example.demo.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bbd")
public class HomeController {

	@Autowired
	private DiscussService discussService;
	
	@GetMapping
	public String mainPage(Model model, String youtubeVideoId) {
		model.addAttribute("discussList", discussService.getAllDiscuss());
		return "main";
	}
	
	// 密碼變更
	@GetMapping("/codeedit")
	public String codeEditPage() {
		return "member";
	}
	
	// 登出
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/login"; 
	}
	
}
