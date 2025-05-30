package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.entity.Discuss;

public interface DiscussService {
	
	public DiscussDTO createDiscuss(DiscussDTO discussDTO);
	public List<DiscussDTO>getAllDiscuss();
	public Optional<DiscussDTO> getDiscussById(Integer id);
}
