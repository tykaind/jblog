package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

	/************ 로그임폼 ************/
	@RequestMapping("/user/loginForm")
	public String loginForm() {
		System.out.println("[UserController.loginForm()]");
		
		return "user/loginForm";
	}
}
