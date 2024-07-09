package com.mysite.homework7.SimKyuSung;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NotionController6 {
	
	@Autowired
	private NotionService6 notionService;

	@GetMapping("/notion/list")
	public String notionlist(Model model) {
		model.addAttribute("notionList",notionService.getAllnotion());
		return "SimKyuSung/notionlist";
	}
	
	@GetMapping("/notion/create")
	public String create() {
		return "SimKyuSung/createnotion";
	}
	
	@PostMapping("/notion/create")
	public String create(@ModelAttribute Notion6 notion) {
		notionService.create(notion);
		return "redirect:/notion/list";
	}
	
	@GetMapping("/notion/detail/{id}")
	public String detail(Model model, @PathVariable("id")Integer id) {
		model.addAttribute("notion",this.notionService.getNotion(id));
		return "SimKyuSung/notiondetail";
	}
	
	@GetMapping("/notion/delete/{id}")
	public String delete(@PathVariable("id")Integer id) {
		this.notionService.delete(id);
		return "redirect:/notion/list";
	}
	
	@GetMapping("/notion/update/{id}")
	public String update(Model model,@PathVariable("id")Integer id) {
		model.addAttribute("notion",this.notionService.getNotion(id));
		return "SimKyuSung/notionupdate";
	}
	
	@PostMapping("/notion/update")
	public String update(@ModelAttribute Notion6 notion) {
		this.notionService.update(notion);
		return "redirect:/notion/list";
	}
}
