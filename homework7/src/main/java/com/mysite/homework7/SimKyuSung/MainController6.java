package com.mysite.homework7.SimKyuSung;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController6 {

	@GetMapping("/sim")
	public String sim() {
		return "SimKyuSung/sim";
	}
}
