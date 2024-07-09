package com.mysite.homework7.KwonJunhyuk;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mysite.homework7.kwakminjung.Notice3;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class NoticeService4 {
	
	private final NoticeRepository4 noticeRepository;
	
	
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
}
