package com.mysite.homework7.kwakminjung;

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
public class Notice3 {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String title;
	
	private String content;
	
	private LocalDateTime date;
	
	@OneToMany(mappedBy="notice", cascade=CascadeType.REMOVE)
	private List<Comment3> commentlist;
}
