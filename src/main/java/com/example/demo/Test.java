package com.example.demo;

import com.example.demo.util.HashUtil;

public class Test {
	public static void main(String[] args) {
	    String password = "1234";
	    String salt = "eWuV3fMWMN9HRk97FLpMnQ==";

	    String hash = HashUtil.getHash(password, salt);
	    System.out.println("驗證用 hash: " + hash);
	}

}
