package com.example.demo.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "discuss")
public class Discuss {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "discuss_id")
	private Integer discussId;
	
	@Column(name = "title", nullable = false, length = 200)
	private String title;
	
	@Column(name = "description", nullable = false, length = 300)
	private String description;
	
	@Column(name = "youtube_video_id",nullable = false, length = 50)
	private String youtubeVideoId;
	
	@Column(name = "created_time")
	private LocalDateTime createdTime = LocalDateTime.now();
	
}
