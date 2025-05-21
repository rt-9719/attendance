package com.example.attendance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.attendance.form.LoginForm;
import com.example.attendance.service.LoginService;

@Controller
public class LoginController extends AbstractController{
	
	@Autowired
	LoginForm loginForm;
	
	@Autowired
	LoginService loginService;
	
	final String loginPage = "login/login";
	
	/**
	 * 初期画面
	 * @param mv
	 * @return
	 */
	@GetMapping (value = "/")
	public ModelAndView LoginIndex(ModelAndView mv) {
		mv.setViewName(loginPage);
		return mv;
	}
	
	/**
	 * ログインボタン
	 * @param loginForm
	 * @param mv
	 * @return
	 */
	@PostMapping (value = "/login", params = "login")
	public ModelAndView Login(@ModelAttribute LoginForm loginForm, ModelAndView mv) {
		
		int loginFlg = loginService.loginCheck(loginForm);
		
		if(loginFlg == 1) {
			mv.setViewName("forward:/top?index"); // TODO ログイン後の画面にする
		} else {
			mv.addObject("errorMsg", "ユーザーID、パスワード、企業IDのいずれかが間違っています");
			mv.setViewName("login/login");
		}
		
		return mv;
	}
	
	
	
}
