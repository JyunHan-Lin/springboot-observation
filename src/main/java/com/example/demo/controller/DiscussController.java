package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.entity.Discuss;
import com.example.demo.service.DiscussService;


@Controller
@RequestMapping("/bbd/discuss")
public class DiscussController {
	
	@Autowired
	private DiscussService discussService;
	
	@GetMapping("/new")
	public String createDiscuss(Model model) {
		model.addAttribute("discussDTO", new DiscussDTO());
		return "discuss/discuss-new";
	}
	
	@PostMapping("/new")
	public String saveDiscuss(@ModelAttribute DiscussDTO discussDTO) {
		DiscussDTO savedDiscuss = discussService.createDiscuss(discussDTO);
	    return "redirect:/bbd/discuss/" + savedDiscuss.getDiscussId();
	}
	
	@GetMapping("/{id}")
	public String viewReport(@PathVariable Integer id, Model model) {
	    DiscussDTO discussDTO = discussService.getDiscussById(id)
	                        .orElseThrow(() -> new RuntimeException("DiscussDTO not found"));
	    model.addAttribute("discussDTO", discussDTO);
//	    model.addAttribute("actionRecord", new ActionRecord()); // 新增行為紀錄用的物件
	    return "discuss/discuss"; // JSP頁面名稱
	}
	
	@PostMapping("/{id}")
	public String addActionRecord(@PathVariable Integer id,
	                              @RequestParam String actionType,
	                              @RequestParam(required = false) String description) {
	    // 呼叫Service新增行為紀錄，並關聯到討論id
//	    actionRecordService.addActionRecord(id, actionType, description);
	    return "redirect:/bbd/discuss/" + id;
	}
	
	// 編輯(標題、描述、網址: 點選到裡面再編輯) 

	// 刪除(編輯模式中才能刪除) 
}
