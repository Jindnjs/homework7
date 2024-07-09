package com.mysite.homework7.SimKyuSung;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotionService6 {

	@Autowired
	private NotionRepository6 notionRepository;
	
	public List<Notion6> getAllnotion(){
		List<Notion6> notion=this.notionRepository.findAll();
		return notion;
	}
	
	public void create(Notion6 notion) {
		notion.setDate(LocalDateTime.now());
		this.notionRepository.save(notion);
	}
	
	public Notion6 getNotion(Integer id) {
		Optional<Notion6> notion=this.notionRepository.findById(id);
		return notion.get();
	}
	
	public void delete(Integer id) {
		this.notionRepository.deleteById(id);
	}
	
	public void update(Notion6 notion) {
		this.notionRepository.save(notion);
	}
}
