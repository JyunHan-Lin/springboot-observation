package com.example.demo.controller;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

import com.example.demo.model.dto.BehaviorDTO;
import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.dto.UserCert;
import com.example.demo.model.entity.Discuss;
import com.example.demo.service.BehaviorService;
import com.example.demo.service.DiscussService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
@RequestMapping("/bbd/discuss")
public class DiscussController {
	
	@Autowired
	private DiscussService discussService;
	
	@Autowired
	private BehaviorService behaviorService;
	
	// 建立討論串的頁面
	@GetMapping("/new")
	public String createDiscuss(Model model) {
		model.addAttribute("discussDTO", new DiscussDTO());
		return "discuss/discuss-new";
	}
	
	// 建立討論串
	@PostMapping("/new")
	public String saveDiscuss(@ModelAttribute DiscussDTO discussDTO, HttpSession session) {
		UserCert userCert = (UserCert) session.getAttribute("userCert");
		// 將 userId 放入 DTO
	    discussDTO.setUserId(userCert.getUserId());
		
		DiscussDTO savedDiscuss = discussService.createDiscuss(discussDTO);
	    return "redirect:/bbd/discuss/" + savedDiscuss.getDiscussId();
	}
	
	// 建立後的頁面
	@GetMapping("/{discussId}")
	public String viewReport(@PathVariable Integer discussId, Model model, HttpSession session) {
	    DiscussDTO discussDTO = discussService.getDiscussById(discussId)
	    									  .orElseThrow(() -> new RuntimeException("DiscussDTO not found"));
	    model.addAttribute("discussDTO", discussDTO);
	    
	    UserCert userCert = (UserCert) session.getAttribute("userCert");
	    Integer userId = userCert != null ? userCert.getUserId() : 1; // 預設 userId (測試環境)

	    List<BehaviorDTO> behaviors = behaviorService.getBehaviorsByDiscussAndUser(discussId, userId);

	    // google charts
	    Map<String, Long> actionCountBySubject 
	    	= behaviors.stream()
	        		   .collect(Collectors.groupingBy(BehaviorDTO::getSubject,
	        				    Collectors.mapping(BehaviorDTO::getAction, Collectors.toSet())))
	        		   .entrySet().stream()
	        		   .collect(Collectors.toMap(
	        				   Map.Entry::getKey, e -> (long) e.getValue().size()));
	    
	    model.addAttribute("actionCountBySubject", actionCountBySubject);
	    
	    return "discuss/discuss"; // JSP頁面名稱
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
		// 進行修改
		discussService.updateDiscuss(discussId, discussDTO);
		return "redirect:/bbd/discuss/" + discussId;
	}

	
	// 刪除討論串
	@DeleteMapping("/delete/{discussId}")
	public String deleteRoom(@PathVariable Integer discussId) {
		discussService.deleteDiscuss(discussId);
		return "redirect:/bbd"; // 重導到首頁
	}
	
}
