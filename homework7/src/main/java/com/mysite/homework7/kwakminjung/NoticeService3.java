package com.mysite.homework7.kwakminjung;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mysite.homework7.S3Service;

@Service
public class NoticeService3 {
	
	@Autowired
	private NoticeRepository3 noticeRepository;
	
	@Autowired
	private S3Service s3Service;
	
	public Notice3 getNotice(Integer id) {
		Optional<Notice3> notice = this.noticeRepository.findById(id);
		return notice.orElse(null);
	}
	
	public void create(Notice3 notice, List<MultipartFile> filelist) throws IOException {
		List<String> filenamelist = new ArrayList<>();
		
		for (MultipartFile file : filelist) {
			if (file != null && !file.isEmpty()) {
				String fileName = UUID.randomUUID() + "_" + file.getOriginalFilename();
				filenamelist.add(fileName);
				s3Service.uploadFile(file, fileName);
			}
		}
		
		notice.setImagelist(filenamelist);
		notice.setDate(LocalDateTime.now());
		noticeRepository.save(notice);
	}
	
	public List<Notice3> readlist() {
		return noticeRepository.findAll();
	}
	
	public Notice3 read(Integer id) {
		Optional<Notice3> o = noticeRepository.findById(id);
		return o.get();
	}
	
	public void delete(Integer id) {
		noticeRepository.deleteById(id);
	}
	
	public void update(Notice3 notice) {
		noticeRepository.save(notice);
	}
	
}
