package com.mysite.homework7.KwonJunhyuk;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lombok.RequiredArgsConstructor;

@RequestMapping("/kwon")
@RequiredArgsConstructor
@Controller
public class NoticeController4 {

	private final NoticeService4 noticeService;
	private final NoticeRepository4 noticeRepository;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;

	@GetMapping("")
	public String kwon(Model model) {
		model.addAttribute("notices", noticeService.readlist());

		return "KwonJunhyuk/kwon";
	}

	@GetMapping("/write")
	public String noticelist() {
		return "KwonJunhyuk/noticewrite";
	}

	@PostMapping("/write")
	public String create(@ModelAttribute Notice4 notice,
						 @RequestParam("file") MultipartFile file
						 )throws IOException{
		noticeService.create(notice, file);
		return "redirect:/kwon";
	}

	@GetMapping("/detail/{id}")
	public String noticedetail(Model model, @PathVariable("id") Integer id) {
		
		Notice4 notice = this.noticeService.getNotice(id);
		model.addAttribute("notice", notice);
		model.addAttribute("downpath","https://" + downpath);

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
	
	@GetMapping("/detail")
    public String noticedetail(Model model) {
        List<Notice4> noticeList = this.noticeRepository.findAll();
        model.addAttribute("noticeList", noticeList);
        return "KwonJunhyuk/noticedetail";
    }
	
}
