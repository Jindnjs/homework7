package com.mysite.homework7.kwakminjung;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoticeService3 {
	
	@Autowired
	private NoticeRepository3 noticeRepository;
	
	public Notice3 getNotice(Integer id) {
		Optional<Notice3> notice = this.noticeRepository.findById(id);
		return notice.get();
	}
	
	public void create(Notice3 notice) {
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
