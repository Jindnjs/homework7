package com.mysite.homework7.KwonJunhyuk;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@RequestMapping("/kwon")
@RequiredArgsConstructor
@Controller
public class NoticeController4 {

	private final NoticeService4 noticeService;

	@GetMapping("")
	public String kwon(Model model) {
		model.addAttribute("notices", noticeService.readlist());

		return "KwonJunhyuk/kwon";
	}

	@GetMapping("/noticewrite")
	public String noticelist() {
		return "KwonJunhyuk/noticewrite";
	}

	@PostMapping("/noticewrite")
	public String noticewrite(@ModelAttribute Notice4 notice) {
		noticeService.create(notice);

		return "redirect:/kwon";
	}

	@GetMapping("/detail/{id}")
	public String noticedetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.read(id));

		return "KwonJunhyuk/noticedetail";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") Integer id) {
		noticeService.delete(id);
		return "redirect:/kwon";
	}

	@GetMapping("/update/{id}")
	public String noticeupdate(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.read(id));

		return "KwonJunhyuk/noticeupdate";
	}

	@PostMapping("/update")
	public String noticeudpate(@ModelAttribute Notice4 notice) {
		noticeService.create(notice);

		return "redirect:/kwon";
	}

}
