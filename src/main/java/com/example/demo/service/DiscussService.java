package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.DiscussDTO;

public interface DiscussService {
	
	public DiscussDTO createDiscuss(DiscussDTO discussDTO);
	public List<DiscussDTO>getAllDiscuss();
	public Optional<DiscussDTO> getDiscussById(Integer discussId);
	public List<DiscussDTO> getDiscussByUserId(Integer id);
	public void updateDiscuss(Integer discussId, DiscussDTO discussDTO);
	public void updateDiscuss(Integer discussId, String title, String description, String youtubeVideoId, LocalDateTime createdTime, Integer userId);
	public void deleteDiscuss(Integer discussId);
}
