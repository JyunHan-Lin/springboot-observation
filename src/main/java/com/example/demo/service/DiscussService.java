package com.example.demo.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.dto.DiscussDTO;

public interface DiscussService {
	
	public DiscussDTO createDiscuss(DiscussDTO discussDTO);
	public List<DiscussDTO>getAllDiscuss();
	public Optional<DiscussDTO> getDiscussById(Integer id);
	public void updateRoom(Integer discussId, DiscussDTO discussDTO);
	public void updateRoom(Integer discussId, String title, String description, String youtubeVideoId, LocalDateTime createdTime);
	public void deleteRoom(Integer discussId);
}
