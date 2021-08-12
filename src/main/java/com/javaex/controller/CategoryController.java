package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;

@Controller
public class CategoryController {

	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CategoryService categoryService;

	
	@RequestMapping("/{id}/admin/basic")
	public String adminlogo(Model model,@PathVariable("id")String id) {
		System.out.println("블로그컨트롤러-어드민이미지로고");
		BlogVo blogVo = blogService.myblog(id);
		model.addAttribute("blogVo",blogVo);

	return "blog/admin/blog-admin-basic";
		
	}
	@RequestMapping("/admin/basicjoin/{id}")
	public String logoJoin(@PathVariable("id")String id,@RequestParam("blogTitle") String blogTitle,@RequestParam("file") MultipartFile file) {
		System.out.println("블로그컨트롤러-이미지로고 조인");
		System.out.println(id);
		System.out.println(blogTitle);
		if(file.getOriginalFilename() == "") {
			BlogVo logore = categoryService.logorecycle(id);
			String logoName = logore.getLogoFile();
		    categoryService.logoJoinrecyle(id,blogTitle,logoName);
		}else {
			categoryService.logoJoin(id,blogTitle,file);
		}
	return "redirect:/{id}";
	}
}
