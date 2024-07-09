package com.mysite.homework7.kwakminjung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/kwak")
@Controller
public class NoticeController3 {
	
	@Autowired
	private NoticeService3 noticeService;
	
	@GetMapping("")
	public String kwak(Model model) {
		model.addAttribute("notices", noticeService.readlist());
		
		return "kwakminjung/kwak";
	}
	
	@GetMapping("/noticewrite")
	public String noticewrite() {
		return "kwakminjung/noticewrite";
	}
	
	@PostMapping("/noticewrite")
	public String noticewrite(@ModelAttribute Notice3 notice) {
		noticeService.create(notice);
		
		return "redirect:/kwak";
	}
	
	@GetMapping("/detail/{id}")
	public String detailnotice(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.read(id));
		
		return "kwakminjung/noticedetail";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		noticeService.delete(id);
		return "redirect:/kwak";
	}
	
	@GetMapping("/update/{id}")
	public String noticeupdate(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.read(id));
		
		return "kwakminjung/noticeupdate";
	}
	
	@PostMapping("/update")
	public String noticeudpate(@ModelAttribute Notice3 notice) {
		noticeService.create(notice);
		
		return "redirect:/kwak";
	}
	
	
	
}
