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
import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.dto.UserCert;
import com.example.demo.service.BehaviorService;
import com.example.demo.service.DiscussService;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/bbd/discuss")
public class ChartsController {

	@Autowired
	private DiscussService discussService;
	
	@Autowired
	private BehaviorService behaviorService;
	
	// 建立後的頁面
		@GetMapping("/{discussId}")
		public String viewReport(@PathVariable Integer discussId, Model model, HttpSession session) {
		    DiscussDTO discussDTO = discussService.getDiscussById(discussId)
		    									  .orElseThrow(() -> new RuntimeException("DiscussDTO not found"));
		    // 取出登入者
		    UserCert userCert = (UserCert) session.getAttribute("userCert");
		    Integer userId = userCert != null ? userCert.getUserId() : null; // 預設 userId (測試環境)
		    
		    // 安全驗證：只允許建立者瀏覽
		    if (!userId.equals(discussDTO.getUserId())) {
		    	throw new RuntimeException("並非討論串建立者無法檢視討論串");
		    }
		    
		    model.addAttribute("discussDTO", discussDTO);

		    // 行為資料
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
		    
		    
		    // google charts
		    Map<String, Long> actionCountBySubject1 
		    	= behaviors.stream()
		        		   .collect(Collectors.groupingBy(BehaviorDTO::getSubject,
		        				    Collectors.mapping(BehaviorDTO::getAction, Collectors.toSet())))
		        		   .entrySet().stream()
		        		   .collect(Collectors.toMap(
		        				   Map.Entry::getKey, e -> (long) e.getValue().size()));
		    
		    model.addAttribute("actionCountBySubject1", actionCountBySubject1);
		    
		    
		    // google charts
		    Map<String, Long> actionCountBySubject2 
		    	= behaviors.stream()
		        		   .collect(Collectors.groupingBy(BehaviorDTO::getSubject,
		        				    Collectors.mapping(BehaviorDTO::getAction, Collectors.toSet())))
		        		   .entrySet().stream()
		        		   .collect(Collectors.toMap(
		        				   Map.Entry::getKey, e -> (long) e.getValue().size()));
		    
		    model.addAttribute("actionCountBySubject2", actionCountBySubject2);
		    
		    return "discuss/discuss"; // JSP頁面名稱
		}
}
