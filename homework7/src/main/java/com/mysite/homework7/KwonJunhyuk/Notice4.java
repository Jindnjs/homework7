package com.mysite.homework7.KwonJunhyuk;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity
public class Notice4 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String title;
	
	private String content;
	
	private LocalDateTime date;
	
	@OneToMany(mappedBy = "notice", cascade = CascadeType.REMOVE) 
    private List<Comment4> commentList; 
	
}