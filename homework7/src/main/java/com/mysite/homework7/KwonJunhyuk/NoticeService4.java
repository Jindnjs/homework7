package com.mysite.homework7.KwonJunhyuk;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.homework7.S3Service;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class NoticeService4 {
	
	private final NoticeRepository4 noticeRepository;
	private final S3Service s3Service;
	
	public List<Notice4> readlist() {
		return noticeRepository.findAll();
	}
	
	public Notice4 read(Integer id) {
		Optional<Notice4> o = noticeRepository.findById(id);
		return o.get();
	}
	

	public void create(Notice4 notice) {
		notice.setDate(LocalDateTime.now());
		noticeRepository.save(notice);
	}
	
	public void delete(Integer id) {
		noticeRepository.deleteById(id);
	}
	
	public void update(Notice4 notice) {
		noticeRepository.save(notice);
	}
	
	public Notice4 getNotice(Integer id) {
		Optional<Notice4> notice = this.noticeRepository.findById(id);
		return notice.get();
	}
	
	public void create(Notice4 notice, MultipartFile file1) throws IOException{
		
		UUID uuid = UUID.randomUUID();
		String fileName1 = uuid + "_" + file1.getOriginalFilename();
		
		s3Service.uploadFile(file1, fileName1);
		
		notice.setImage1(fileName1);
		
		notice.setDate(LocalDateTime.now());
		this.noticeRepository.save(notice);
	}
		
}
