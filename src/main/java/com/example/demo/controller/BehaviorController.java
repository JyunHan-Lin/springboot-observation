package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
	
	@GetMapping("/{discussId}/list")
	public String showDiscussList(Model model) {
	    List<BehaviorDTO> behaviorList = behaviorService.getAllBehavior();
	    model.addAttribute("behaviorList", behaviorList);
	    return "discuss-list";
	}
	
}
