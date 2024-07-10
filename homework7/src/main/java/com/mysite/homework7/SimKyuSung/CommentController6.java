package com.mysite.homework7.SimKyuSung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CommentController6 {
	
	@Autowired
	private CommentService6 commentService;
	
	@Autowired
	private NotionService6 notionService;

	@PostMapping("/comment6/create/{id}")
	public String create(@PathVariable("id")Integer id,@RequestParam("content")String content) {
		Notion6 notion=this.notionService.getNotion(id);
		this.commentService.create(notion, content);
		return "redirect:/notion/detail/"+id;
	}
}
