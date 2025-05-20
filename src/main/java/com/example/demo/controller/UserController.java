package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.service.UserLoginService;

@Controller
@RequestMapping(value = "/bbd")
public class UserController {
	
	@Autowired 
	private UserLoginService userLoginService;
	
	public String test() {
	return "index";
	}
}
