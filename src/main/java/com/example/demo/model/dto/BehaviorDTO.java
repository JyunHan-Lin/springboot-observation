package com.example.demo.model.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BehaviorDTO {
	private Integer behaviorId;
    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private String subject;
    private String action;
    private Float temperature;
    private String note;
	private LocalDateTime createdTime = LocalDateTime.now();
	private Integer discussId;
	
	// 自訂日期格式 (年/月/日/分)
	public String getFormattedCreatedTime() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
	    return createdTime.format(formatter);
	}
}
