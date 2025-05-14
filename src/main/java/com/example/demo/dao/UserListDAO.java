package com.example.demo.dao;

import java.util.List;

import com.example.demo.model.entity.User;

public interface UserListDAO {
	List<User> findAllUsers();
}
