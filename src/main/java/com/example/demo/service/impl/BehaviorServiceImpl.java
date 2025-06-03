package com.example.demo.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.dto.BehaviorDTO;
import com.example.demo.model.entity.Behavior;
import com.example.demo.model.entity.Discuss;
import com.example.demo.repository.BehaviorRepository;
import com.example.demo.repository.DiscussRepository;
import com.example.demo.service.BehaviorService;

@Service
public class BehaviorServiceImpl implements BehaviorService{

	@Autowired
	private BehaviorRepository behaviorRepository;
	
	@Autowired
	private DiscussRepository discussRepository;
	
    public void saveBehavior(Integer discussId, BehaviorDTO behaviorDTO) {
        Optional<Discuss> discussOpt = discussRepository.findById(discussId);
        if (discussOpt.isPresent()) {
            Discuss discuss = discussOpt.get();
            
        Behavior behavior = new Behavior();
        behavior.setDate(behaviorDTO.getDate());
        behavior.setStartTime(behaviorDTO.getStartTime());
        behavior.setEndTime(behaviorDTO.getEndTime());
        behavior.setSubject(behaviorDTO.getSubject());
        behavior.setAction(behaviorDTO.getAction());
        
        behavior.setTemperature(behaviorDTO.getTemperature());
        behavior.setHumidity(behaviorDTO.getHumidity());
        behavior.setNote(behaviorDTO.getNote());

        behavior.setDiscuss(discuss); // 關聯討論串

        behaviorRepository.save(behavior);
        }
    }
}
