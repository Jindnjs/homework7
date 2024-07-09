package com.mysite.homework7.SimKyuSung;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService6 {

	@Autowired
	private CommentRepository6 commentRepository;
	
	public void create(Notion6 notion,String content) {
		Comment6 comment=new Comment6();
		comment.setContent(content);
		comment.setDate(LocalDateTime.now());
		comment.setNotion(notion);
		this.commentRepository.save(comment);
	}
}
