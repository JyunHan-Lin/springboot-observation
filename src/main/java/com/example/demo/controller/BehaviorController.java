package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.BehaviorDTO;
import com.example.demo.repository.DiscussRepository;
import com.example.demo.service.BehaviorService;

@Controller
@RequestMapping("/bbd/discuss/behavior")
public class BehaviorController {
	
	@Autowired
	private BehaviorService behaviorService;
	
	@Autowired
	private DiscussRepository discussRepository;
	
	@PostMapping("/{discussId}")
	public String save(@PathVariable Integer discussId, BehaviorDTO behaviorDTO) {
		behaviorService.saveBehavior(discussId, behaviorDTO);
		return "redirect:/bbd/discuss/" + discussId;
	}
}
