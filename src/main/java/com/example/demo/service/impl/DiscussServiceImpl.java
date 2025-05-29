package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.entity.Discuss;
import com.example.demo.repository.DiscussRepository;
import com.example.demo.service.DiscussService;

@Service
public class DiscussServiceImpl implements DiscussService{

	@Autowired
	private DiscussRepository discussRepository;
	
	@Override
	public Discuss createDiscuss(Discuss discuss) {
		return discussRepository.save(discuss);
	}

	@Override
	public List<Discuss> getAllDiscuss() {
		return discussRepository.findAll();
	}

	@Override
	public Optional<Discuss> getDiscussById(Integer id) {
		return discussRepository.findById(id);
	}

}
