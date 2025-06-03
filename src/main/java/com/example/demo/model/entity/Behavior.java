package com.example.demo.model.entity;

import java.time.LocalDate;
import java.time.LocalTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Behavior {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自動生成 id
	@Column(name = "behavior_id")
	private Integer behaviorId;
	
	@Column(name = "date", nullable = false)
    private LocalDate date;
	
	@Column(name = "start_time", nullable = false)
    private LocalTime startTime;
	
	@Column(name = "end_time", nullable = false)
    private LocalTime endTime;

	@Column(name = "subject", nullable = false)
    private String subject;
	
	@Column(name = "action", nullable = false)
    private String action;
	
	@Column(name = "temperature")
    private Integer temperature;
	
	@Column(name = "humidity")
    private Integer humidity;
	
	@Column(name = "note", length = 100)
    private String note;
	
	@ManyToOne
	@JoinColumn(name = "discuss_id") // 資料庫欄位名
	private Discuss discuss;
}
