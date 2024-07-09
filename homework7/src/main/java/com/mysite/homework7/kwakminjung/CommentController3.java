package com.mysite.homework7.kwakminjung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/kwak/comment")
@Controller
public class CommentController3 {
	
	@Autowired
	private NoticeService3 noticeService;
	
	@Autowired
	private CommentService3 commentService;
	
	@PostMapping("/create/{id}")
	public String create(Model model, @PathVariable("id") Integer id,
			@RequestParam(value="content") String content) {
		
		Notice3 notice = noticeService.getNotice(id);
		
		commentService.create(notice, content);
		
		return "redirect:/kwak/detail/{id}";
	}
	
	
	

}
