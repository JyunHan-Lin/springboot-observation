package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.service.EmailService;
import com.example.demo.service.UserService;
import com.example.demo.util.HashUtil;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping
	public String registerPage() {
		return "register";
	}
	/**	使用者註冊 (新增使用者)
	 * 	@RequestParam：自動接收表單中的 username、password、email 欄位值
	 * 	Model：用來傳值到 JSP 畫面顯示訊息 (用來在「Controller 與 JSP 頁面之間傳遞資料」的容器)
	 **/
	@PostMapping
	public String addUser(@RequestParam String username,
	                      @RequestParam String password,
	                      @RequestParam String email,
	                      Model model) {

		// 呼叫 service 儲存用戶資料 (身分待補##)
	    userService.addUser(username, password, email, false, "user");

	    // 寄送 email 驗證信 (使用 emailService 中的 sendEmail 方法)
	    String emailConfirmLink = "http://localhost:8085/email/confirm?username=" + username;
	    emailService.sendEmail(email, emailConfirmLink);

	    // 顯示結果
	    String resultTitle = "註冊結果";
	    String resultMessage = "用戶 " + username + " 註冊成功!<p />系統已送出驗證信件到 " + email + " 信箱, 請收信並點選[確認]連結";

	    // 將 resultTitle、resultMessage 傳給 JSP (JSP也要有對應的{...})
	    model.addAttribute("resultTitle", resultTitle);
	    model.addAttribute("resultMessage", resultMessage);

	    return "result";
	}
}

