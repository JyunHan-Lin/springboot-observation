package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Behavior;

@Repository
public interface BehaviorRepository extends JpaRepository<Behavior, Integer>{
    List<Behavior> findByDiscuss_DiscussId(Integer discussId);
    
    @Query("SELECT b FROM Behavior b WHERE b.discuss.id = :discussId AND b.discuss.user.id = :userId")
    List<Behavior> findByDiscussIdAndUserId(@Param("discussId") Integer discussId, @Param("userId") Integer userId);

}
