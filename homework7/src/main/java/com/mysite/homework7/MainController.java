package com.mysite.homework7;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	@GetMapping("/yoo")
	public String yoo() {
		return "index";
	}
	@GetMapping("/kim")
	public String kim() {
		return "index";
	}
	@GetMapping("/kwak")
	public String kwak() {
		return "index";
	}
	@GetMapping("/kwon")
	public String kwon() {
		return "index";
	}
	@GetMapping("/park")
	public String park() {
		return "index";
	}
	@GetMapping("/sim")
	public String sim() {
		return "index";
	}
}
