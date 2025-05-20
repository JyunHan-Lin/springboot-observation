package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.service.UserLoginService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
@RequestMapping(value = "/bbd")
public class UserController {
	
	@Autowired 
	private UserLoginService userLoginService;
	
	
	@PostMapping("/login")
	public String login(@Valid UserDTO userDTO, BindingResult bindingResult, Model model, HttpSession session) {
			
		if (bindingResult.hasErrors()) {
		    model.addAttribute("error", "輸入格式錯誤");
		    return "user-login";
		}
        String userName = userDTO.getUserName();
        String password = userDTO.getPassword();
        String authCode = userDTO.getAuthCode();
        String sessionAuthCode = userDTO.getAuthCode();
        
		userLoginService.login(userName, password, authCode, sessionAuthCode);
		return "user-login";
	}

}
