package com.example.attendance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController extends AbstractController{
	
	@GetMapping (value = "/")
	public ModelAndView LoginIndex(ModelAndView mv) {
		
		mv.setViewName("login/login");
		return mv;
	}

}
