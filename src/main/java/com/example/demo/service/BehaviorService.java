package com.example.demo.service;

import java.util.List;

import com.example.demo.model.dto.BehaviorDTO;

public interface BehaviorService {
	public void saveBehavior(Integer discussId, BehaviorDTO behaviorDTO);
	public List<BehaviorDTO> getAllBehavior();
}
