package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bbd")
public class ApiController {

	@Controller
	public class HomeController {
	    @GetMapping("/")
	    public String home() {
	        return "index"; // 對應 /WEB-INF/view/index.jsp
	    }
	}
	
    @GetMapping("/user/login")
    public String loginPage(@RequestParam String q) {
        // 你可以根據參數 q 做一些邏輯處理，例如印出、傳給 JSP 等
        System.out.println("q = " + q);
        return "user_login"; // 對應到 /WEB-INF/view/user_login.jsp
    }
    
    @GetMapping("/user/register")
    public String registerPage(@RequestParam String q) {
        // 你可以根據參數 q 做一些邏輯處理，例如印出、傳給 JSP 等
        System.out.println("q = " + q);
        return "user_register"; // 對應到 /WEB-INF/view/user_login.jsp
    }
    
    @GetMapping("/menu")
    public String menuPage(@RequestParam String q) {
        // 你可以根據參數 q 做一些邏輯處理，例如印出、傳給 JSP 等
        System.out.println("q = " + q);
        return "menu"; // 對應到 /WEB-INF/view/user_login.jsp
    }
    
    @GetMapping("/result")
    public String resultPage(@RequestParam String q, Model model) {
        model.addAttribute("resultTitle", "結果頁面");
        model.addAttribute("resultMessage", "查詢結果為：" + q);
        return "result";
    }
}
