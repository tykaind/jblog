package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	/***** 메인페이지 이동 *****/
	@RequestMapping("/main/index")
	public String mainIndex() {
		System.out.println("controller-메인인덱스");
		
		return "main/index";
	}
}
