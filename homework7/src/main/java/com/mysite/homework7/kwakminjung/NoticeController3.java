package com.mysite.homework7.kwakminjung;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RequestMapping("/kwak")
@Controller
public class NoticeController3 {
	
	@Autowired
	private NoticeService3 noticeService;
	
	@Value("${cloud.aws.s3.endpoint}")
	private String downpath;
	
	@GetMapping("")
	public String kwak(Model model) {
		model.addAttribute("notices", noticeService.readlist());
		model.addAttribute("downpath", "https://" + downpath);
		
		return "kwakminjung/kwak";
	}
	
	@GetMapping("/noticewrite")
	public String noticewrite() {
		return "kwakminjung/noticewrite";
	}
	
	@PostMapping("/noticewrite")
	public String noticewrite(@ModelAttribute Notice3 notice,
	        @RequestParam("image1") MultipartFile image1,
	        @RequestParam("image2") MultipartFile image2,
	        @RequestParam("image3") MultipartFile image3) throws IOException {
	    
	    List<MultipartFile> filelist = new ArrayList<>();
	    if (image1 != null && !image1.isEmpty()) {
	        filelist.add(image1);
	    }
	    if (image2 != null && !image2.isEmpty()) {
	        filelist.add(image2);
	    }
	    if (image3 != null && !image3.isEmpty()) {
	        filelist.add(image3);
	    }
	    
	    noticeService.create(notice, filelist);
	    
	    return "redirect:/kwak";
	}


	
	@GetMapping("/detail/{id}")
	public String detailnotice(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("notice", noticeService.read(id));
		model.addAttribute("downpath", "https://" + downpath);
		
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
		noticeService.update(notice);
		
		return "redirect:/kwak";
	}
	
	
	
}
