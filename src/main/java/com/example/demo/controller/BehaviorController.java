package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/behavior")
public class BehaviorController {
	
	@GetMapping
	public String behaviorPage() {
		return "behavior/behavior";
	}
}
