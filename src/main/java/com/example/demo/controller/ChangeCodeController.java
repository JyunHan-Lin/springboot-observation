package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.service.UserService;

@Controller
@RequestMapping("/bbd/codeedit")
public class ChangeCodeController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public String member() {
		return "member";
	}
	
    @PostMapping
    public String changePassword(@RequestParam("oldPassword") String oldPassword,
                                 @RequestParam("newPassword") String newPassword,
                                 @RequestParam("confirmPassword") String confirmPassword,
                                 Principal principal,
                                 RedirectAttributes redirectAttributes) {

        String email = principal.getName(); // 使用登入者帳號
        boolean result = userService.changePassword(email, oldPassword, newPassword, confirmPassword);

        if (result) {
            redirectAttributes.addFlashAttribute("successMessage", "密碼變更成功！");
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "密碼變更失敗，請確認原密碼與新密碼是否符合。");
        }

        return "redirect:/bbd/user/change-password";
    }
}
