package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Behavior;

@Repository
public interface BehaviorRepository extends JpaRepository<Behavior, Integer>{
    List<Behavior> findByDiscuss_DiscussId(Integer discussId);
}
