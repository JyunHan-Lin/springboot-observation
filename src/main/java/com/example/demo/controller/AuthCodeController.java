package com.example.demo.controller;

import com.example.demo.service.AuthCodeService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class AuthCodeController {

    @Autowired
    private AuthCodeService authCodeService;

    @GetMapping("/user/authcode")
    public void getAuthCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession();

        // 產生驗證碼
        String authcode = authCodeService.generateAuthCode();

        // 存入 session 以供登入時比對
        session.setAttribute("authcode", authcode);

        // 設定回應格式為圖片
        response.setContentType("image/jpeg");

        // 輸出圖片
        BufferedImage image = authCodeService.createAuthCodeImage(authcode);
        ImageIO.write(image, "JPEG", response.getOutputStream());
    }
}
