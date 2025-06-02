package com.example.demo.service.impl;

import java.time.LocalDateTime;
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
	
	// 建立討論串
	@Override
	public DiscussDTO createDiscuss(DiscussDTO discussDTO) {
	    Discuss discuss = discussMapper.toEntity(discussDTO); // 將 DTO 轉成 Entity
	    Discuss savedDiscuss = discussRepository.save(discuss); // 存進 DB
	    return discussMapper.toDTO(savedDiscuss); // 存完再轉成 DTO 回傳
	}

	// 查看所有討論串
	@Override
	public List<DiscussDTO> getAllDiscuss() {
	    List<Discuss> discusses = discussRepository.findAll();
	    return discusses.stream()
	            		.map(discussMapper::toDTO)
	            		.toList();
	}
	
	// 依照討論串id找到建立的頁面
	@Override
	public Optional<DiscussDTO> getDiscussById(Integer id) {
	    return discussRepository.findById(id)
	            .map(discussMapper::toDTO);
	}
	
	// 編輯討論串
	@Override
	public void updateRoom(Integer discussId, DiscussDTO discussDTO) {
		// 判斷該房號是否已存在?
		Optional<Discuss> optDiscuss = discussRepository.findById(discussId);
		if (optDiscuss.isEmpty()) {
			throw new RuntimeException("修改失敗: 房號" + discussDTO.getDiscussId() + "不存在");
		}
		discussDTO.setDiscussId(discussId);
		Discuss discuss = discussMapper.toEntity(discussDTO);
		discussRepository.saveAndFlush(discuss); // 更新(馬上強制寫入更新)
	}

	@Override
	public void updateRoom(Integer discussId, String title, String description, String youtubeVideoId, LocalDateTime createdTime) {
		DiscussDTO discussDTO = new DiscussDTO(discussId, title, description, youtubeVideoId, createdTime);
		updateRoom(discussId, discussDTO);		
	}

	@Override
	public void deleteRoom(Integer discussId) {
		// 判斷該房號是否已存在?
		Optional<Discuss> optDiscuss = discussRepository.findById(discussId);
		if (optDiscuss.isEmpty()) {
			throw new RuntimeException("刪除失敗: 房號" + discussId + "不存在");
		}
		discussRepository.deleteById(discussId);
	}
}
