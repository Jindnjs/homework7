package com.mysite.homework7.KwonJunhyuk;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mysite.homework7.kwakminjung.Comment3;
import com.mysite.homework7.kwakminjung.Notice3;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService4 {

	private final CommentRepository4 commentRepository;
	
	public List<Comment4> readlist() {
		return commentRepository.findAll();
	}
	

	public void create(Notice4 notice, String content) {
		Comment4 comment = new Comment4();
		comment.setContent(content);
		comment.setDate(LocalDateTime.now());
		comment.setNotice(notice);
		commentRepository.save(comment);
	}
}
