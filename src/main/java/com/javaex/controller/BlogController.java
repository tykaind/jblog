package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.BlogVo;

@Controller
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{id}")
	public String blogForm(Model model,@PathVariable("id")String id) {
		System.out.println("블로그컨트롤러-블로그메인");
		System.out.println(id);
		
		BlogVo blogVo = blogService.myblog(id);
		model.addAttribute("blogVo", blogVo);
		return "blog/blog-main";
	}
	
	
}

