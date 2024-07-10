package com.mysite.homework7.KwonJunhyuk;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data
@Entity
public class Comment4 {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String content;
	
	private LocalDateTime date;
	
	private String image1;
	
	@ManyToOne 
    private Notice4 notice;  
}
