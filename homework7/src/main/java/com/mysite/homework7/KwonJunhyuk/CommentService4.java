package com.mysite.homework7.KwonJunhyuk;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.homework7.S3Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CommentService4 {

	private final CommentRepository4 commentRepository;
	private final S3Service s3Service;

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

	public void create(Comment4 comment, MultipartFile file1) throws IOException {

		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename();

		s3Service.uploadFile(file1, fileName1);

		comment.setImage1(fileName1);
		comment.setDate(LocalDateTime.now());
		this.commentRepository.save(comment);
	}
}
