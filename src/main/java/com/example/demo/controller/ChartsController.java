package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.dto.BehaviorDTO;
import com.example.demo.model.entity.Behavior;
import com.example.demo.service.BehaviorService;

@Controller
@RequestMapping("/bbd/discuss/stats/{discussId}")
public class ChartsController {

	@Autowired
	private BehaviorService behaviorService;
	
	@GetMapping
	public String showStats(@PathVariable Integer discussId, Integer userId, Model model) {
	    List<BehaviorDTO> behaviors = behaviorService.getBehaviorsByDiscussAndUser(discussId, userId);

	    // 範例：同個日期+對象出現次數 Map<日期_對象, 次數>
	    Map<String, Long> countByDateSubject = behaviors.stream()
	        .collect(Collectors.groupingBy(
	            b -> b.getDate().toString() + "_" + b.getSubject(), Collectors.counting()));

	    // 範例：同個日期中每個行為佔用的時間(分鐘)
	    Map<String, Long> durationByDateAction = behaviors.stream()
	        .collect(Collectors.groupingBy(
	            b -> b.getDate().toString() + "_" + b.getAction(),
	            Collectors.summingLong(b -> {
	                // 轉換時間為分鐘差
	                long start = b.getStartTime().toSecondOfDay();
	                long end = b.getEndTime().toSecondOfDay();
	                return (end - start) / 60;
	            })));

	    // 同個對象有幾種行為數量
	    Map<String, Long> actionCountBySubject = behaviors.stream()
	    												  .collect(Collectors.groupingBy(
	            BehaviorDTO::getSubject,
	            Collectors.mapping(
	            BehaviorDTO::getAction, 
	            Collectors.toSet())))
	        .entrySet().stream()
	        .collect(Collectors.toMap(
	            Map.Entry::getKey,
	            e -> (long) e.getValue().size()));

	    model.addAttribute("countByDateSubject", countByDateSubject);
	    model.addAttribute("durationByDateAction", durationByDateAction);
	    model.addAttribute("actionCountBySubject", actionCountBySubject);

	    return "discuss/behavior-stats";  // 對應 JSP 頁面
	}

}
