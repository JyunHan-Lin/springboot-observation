package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

@Service
public class AuthCodeService {

    // 產生 4 位數字驗證碼
    public String generateAuthCode() {
        return String.format("%04d", new Random().nextInt(10000));
    }

    // 根據驗證碼產生圖像
    public BufferedImage createAuthCodeImage(String authcode) {
        BufferedImage img = new BufferedImage(80, 30, BufferedImage.TYPE_INT_RGB);
        Graphics g = img.getGraphics();

        // 背景
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 80, 30);

        // 文字
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 22));
        g.drawString(authcode, 18, 22);

        // 干擾線
        g.setColor(Color.RED);
        Random random = new Random();
        for (int i = 0; i < 20; i++) {
            int x1 = random.nextInt(80);
            int y1 = random.nextInt(30);
            int x2 = random.nextInt(80);
            int y2 = random.nextInt(30);
            g.drawLine(x1, y1, x2, y2);
        }

        return img;
    }
}
