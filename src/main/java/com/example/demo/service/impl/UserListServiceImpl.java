package com.example.demo.service.impl;

import java.util.List;

import com.example.demo.model.dto.UserDTO;
import com.example.demo.model.entity.User;
import com.example.demo.service.UserListService;
import com.example.demo.dao.UserListDAO;
import com.example.demo.dao.impl.UserListDAOImpl;

public class UserListServiceImpl implements UserListService{
	private UserListDAO userListDAO = new UserListDAOImpl();
	@Override
	public List<UserDTO> findAllUsers() {
		// 1.從 userListDAO 取得 List<User>
		List<User> users = userListDAO.findAllUsers();
		
		// 2.將 List<User> 每一個元素由 User 轉成 UserDTO 使之變成 List<UserDTO>
		List<UserDTO> userDTOs = users.stream()
									  .map(user -> {
										  UserDTO userDTO = new UserDTO();
										  userDTO.setId(user.getId());
										  userDTO.setUsername(user.getUsername());
										  userDTO.setEmail(user.getEmail());
										  userDTO.setCompleted(user.getCompleted());
										  return userDTO;
									  })
									  .toList();
		
		return userDTOs;
	}
}
