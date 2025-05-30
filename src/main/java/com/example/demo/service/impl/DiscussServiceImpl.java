package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.mapper.DiscussMapper;
import com.example.demo.model.dto.DiscussDTO;
import com.example.demo.model.entity.Discuss;
import com.example.demo.repository.DiscussRepository;
import com.example.demo.service.DiscussService;

@Service
public class DiscussServiceImpl implements DiscussService{

	@Autowired
	private DiscussRepository discussRepository;
	
	@Autowired
	private DiscussMapper discussMapper;
	
	@Override
	public DiscussDTO createDiscuss(DiscussDTO discussDTO) {
	    Discuss discuss = discussMapper.toEntity(discussDTO); // 將 DTO 轉成 Entity
	    Discuss savedDiscuss = discussRepository.save(discuss); // 存進 DB
	    return discussMapper.toDTO(savedDiscuss); // 存完再轉成 DTO 回傳
	}


	@Override
	public List<DiscussDTO> getAllDiscuss() {
	    List<Discuss> discusses = discussRepository.findAll();
	    return discusses.stream()
	            .map(discussMapper::toDTO)
	            .toList();
	}

	@Override
	public Optional<DiscussDTO> getDiscussById(Integer id) {
	    return discussRepository.findById(id)
	            .map(discussMapper::toDTO);
	}


}
