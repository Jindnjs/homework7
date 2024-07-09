package com.mysite.homework7.yoojinwon.Notice;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class NoticeController1 {
	
	private final NoticeService1 ns;
	@GetMapping("/yoo")
	public String showNotices(Model model) {
		model.addAttribute("noticeList", ns.findallnotice());
		return "yoojinwon/noticelist1";
	}
	
	@GetMapping("/notice/add")
	public String addnotice() {
		return "yoojinwon/addnotice1";
	}
	
	@PostMapping("/notice/create")
	public String createnotice(@ModelAttribute Notice1 notice) {
		
		ns.createnotice(notice);
		
		return "redirect:/yoo";
	}
	
	@GetMapping("/notice/detail/{id}")
	public String shownotice(Model model, 
							@PathVariable("id") Integer id) {
		model.addAttribute("notice",ns.getnoticeByid(id));
		return "yoojinwon/noticedetail1";
	}
	
	@GetMapping("/notice/detail/delete/{id}")
	public String deleteNotice(@PathVariable("id") Integer id) {
		ns.deleteNotice(id);
		return "redirect:/yoo";
	}
	@GetMapping("/notice/detail/update/{id}")
	public String updateNotice(Model model,@PathVariable("id") Integer id) {
		model.addAttribute("notice",ns.getnoticeByid(id));
		return "yoojinwon/noticefix1";
	}
	@PostMapping("/notice/update")
	public String update(@ModelAttribute Notice1 notice) {
		ns.update(notice);
		return "redirect:/yoo";
	}
}
