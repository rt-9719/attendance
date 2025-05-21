package com.example.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TopController extends AbstractController {
	
	@PostMapping(value = "top", params = "index")
	public String goTop() {
		return "top/top";
	}

}
