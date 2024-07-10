package com.mysite.homework7.KwonJunhyuk;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@RequestMapping("/kwon/comment")
@RequiredArgsConstructor
@Controller
public class CommentController4 {

	private final CommentService4 commentService;
	private final NoticeService4 noticeService;
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;
	
	@PostMapping("/create/{id}")
	public String create(Model model, @PathVariable("id") Integer id,
			@RequestParam(value="content") String content) {
		Notice4 notice = noticeService.getNotice(id);
		
		commentService.create(notice, content);
		
		return "redirect:/kwon/detail/{id}";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(Model model) {
		model.addAttribute("notices", noticeService.readlist());
		model.addAttribute("downpath", "https://" + downpath);
		return "readlist";
	}
}
	

