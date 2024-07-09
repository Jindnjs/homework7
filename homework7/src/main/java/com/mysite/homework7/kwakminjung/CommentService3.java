package com.mysite.homework7.kwakminjung;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService3 {
	
	@Autowired
	private CommentRepository3 commentRepository;
	
	public void create(Notice3 notice, String content) {
		Comment3 comment = new Comment3();
		comment.setContent(content);
		comment.setDate(LocalDateTime.now());
		comment.setNotice(notice);
		commentRepository.save(comment);
	}
	
	public List<Comment3> read() {
		return commentRepository.findAll();
	}
}
