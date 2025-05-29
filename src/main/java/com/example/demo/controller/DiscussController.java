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

import com.example.demo.model.entity.Discuss;
import com.example.demo.service.DiscussService;


@Controller
@RequestMapping("/bbd/discuss")
public class DiscussController {
	
	@Autowired
	private DiscussService discussService;
	
	@GetMapping("/new")
	public String createDiscuss(Model model) {
		model.addAttribute("discuss", new Discuss());
		return "discuss/discuss-new";
	}
	
	@PostMapping("/new")
	public String saveDiscuss(@ModelAttribute Discuss discuss) {
		Discuss savedDiscuss = discussService.createDiscuss(discuss);
	    return "redirect:/bbd/discuss/" + savedDiscuss.getDiscussId();
	}
	
	@GetMapping("/{id}")
	public String viewReport(@PathVariable Integer id, Model model) {
	    Discuss discuss = discussService.getDiscussById(id)
	                        .orElseThrow(() -> new RuntimeException("Discuss not found"));
	    model.addAttribute("discuss", discuss);
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
	
	// 編輯(標題、描述、) 

	// 刪除
}
