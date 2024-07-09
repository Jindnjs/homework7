package com.mysite.homework7.yoojinwon.Notice;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NoticeService1 {

	private final NoticeRepository1 nr;
	
	public void createnotice(Notice1 notice) {
		notice.setDate(LocalDateTime.now());
		this.nr.save(notice);
	}
	public List<Notice1> findallnotice(){
		return nr.findAll();
	}
	public Notice1 getnoticeByid(Integer id) {
		
		Optional<Notice1> op = this.nr.findById(id);
		return op.get();
	}
	public void deleteNotice(Integer id) {
		nr.deleteById(id);
	}
	public void update(Notice1 notice) {
		nr.save(notice);
	}
}
