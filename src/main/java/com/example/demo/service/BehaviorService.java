package com.example.demo.service;

import com.example.demo.model.dto.BehaviorDTO;

public interface BehaviorService {
	public void saveBehavior(Integer discussId, BehaviorDTO behaviorDTO);
}
