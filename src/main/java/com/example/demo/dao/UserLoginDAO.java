package com.example.demo.dao;

import com.example.demo.model.entity.User;

public interface UserLoginDAO {
	User findUserByName(String username);

}
