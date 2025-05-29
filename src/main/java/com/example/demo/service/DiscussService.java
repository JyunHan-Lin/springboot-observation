package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.entity.Discuss;

public interface DiscussService {
	
	public Discuss createDiscuss(Discuss discuss);
	public List<Discuss>getAllDiscuss();
	public Optional<Discuss> getDiscussById(Integer id);
}
