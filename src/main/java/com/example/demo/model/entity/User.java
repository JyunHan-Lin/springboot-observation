package com.example.demo.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	
	@Column(name = "username")
	private String userName;	
	
	@Column(name = "hash_password")
	private String hashPassword;	
	
	@Column(name = "hash_salt")
	private String hashSalt;	
	
	@Column(name = "email")
	private String email;	
	
	@Column(name = "authcode")
	private Integer authCode;	
	
	@Column(name = "completed")
	private Boolean completed;	

}
