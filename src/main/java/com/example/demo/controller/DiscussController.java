package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.entity.Discuss;
import com.example.demo.service.DiscussService;

import jakarta.validation.Valid;


@Controller
@RequestMapping("/bbd/discuss")
public class DiscussController {
	
	@Autowired
	private DiscussService discussService;
	
	// 建立討論串的頁面
	@GetMapping("/new")
	public String createDiscuss(Model model) {
		model.addAttribute("discussDTO", new DiscussDTO());
		return "discuss/discuss-new";
	}
	
	// 建立討論串
	@PostMapping("/new")
	public String saveDiscuss(@ModelAttribute DiscussDTO discussDTO) {
		DiscussDTO savedDiscuss = discussService.createDiscuss(discussDTO);
	    return "redirect:/bbd/discuss/" + savedDiscuss.getDiscussId();
	}
	
	// 建立後的頁面
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
	
	// 編輯討論串(標題、描述、網址: 點選到裡面再編輯) 
	@GetMapping("/update/{discussId}")
	public String showEditDiscuss(@PathVariable Integer discussId, Model model) {
	    DiscussDTO discussDTO = discussService.getDiscussById(discussId)
	    									  .orElseThrow(() -> new RuntimeException("DiscussDTO not found"));
	    model.addAttribute("discussDTO", discussDTO);
	    return "discuss/discuss-edit"; // 編輯頁面的 JSP 名稱
	}

	@PutMapping("/update/{discussId}")
	public String updateRoom(@PathVariable Integer discussId, @Valid DiscussDTO discussDTO, BindingResult bindingResult) {
		// 驗證資料
//		if (bindingResult.hasErrors()) { // 若驗證時有錯誤發生
//			return "discuss/discuss-edit";
//		}
		
		// 進行修改
		discussService.updateRoom(discussId, discussDTO);
		return "redirect:/bbd/discuss/" + discussId;
	}

	
	// 刪除
	@DeleteMapping("/delete/{discussId}")
	public String deleteRoom(@PathVariable Integer discussId) {
		discussService.deleteRoom(discussId);
		return "redirect:/bbd"; // 重導到首頁
	}
	
}
