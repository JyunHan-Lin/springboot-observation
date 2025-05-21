package com.example.demo.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 id
	@Column(name = "user_id") // 資料表 user 中的預設欄位名稱
	private Integer userId;	// 使用者 ID
	
	@Column(name = "username", unique = true, nullable = false, length = 50) 
	private String username; 
	
	@Column(name = "password_hash", nullable = false) // 不寫 length 預設為255 
	private String passwordHash;
	
	@Column(name = "salt", nullable = false) // 不寫 length 預設為255 
	private String salt;
	
	@Column(name = "email", nullable = false) 
	private String email;
	
	@Column(name = "active")
	private Boolean active;
	
	@Column(name = "role")  
	private String role;

}
