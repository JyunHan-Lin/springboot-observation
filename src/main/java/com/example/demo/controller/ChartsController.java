package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.BehaviorDTO;
import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.entity.Behavior;
import com.example.demo.service.BehaviorService;

@Controller
@RequestMapping("/bbd/discuss/stats")
public class ChartsController {
	@Autowired
	private BehaviorService behaviorService;
	
	@GetMapping("/{discussId}")
	public String showCharts(
	    @PathVariable Integer discussId,
	    @RequestParam(required = false) Integer userId, // 可從 URL 參數取得 userId
	    Model model) {
		System.out.println("Controller 方法被呼叫");

	    // 若 userId 為 null，給預設值或跳轉提示
	    if(userId == null) {
	        userId = 1; // 或其他預設 userId
	    }

	    List<BehaviorDTO> behaviors = behaviorService.getBehaviorsByDiscussAndUser(discussId, userId);

	    Map<String, Long> actionCountBySubject = behaviors.stream()
													      .collect(Collectors.groupingBy(
													       BehaviorDTO::getSubject,
													       Collectors.mapping(BehaviorDTO::getAction, Collectors.toSet())))
													      .entrySet().stream()
													      .collect(Collectors.toMap(
													       Map.Entry::getKey,
													       e -> (long) e.getValue().size()));

	    model.addAttribute("actionCountBySubject", actionCountBySubject);
	    System.out.println("actionCountBySubject: " + actionCountBySubject);
	    return "charts/googlecharts-head.jspf";
	}


}
