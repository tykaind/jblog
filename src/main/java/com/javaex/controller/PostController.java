package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;

	@RequestMapping("/{id}/admin/writeForm")
	public String writeForm(@PathVariable("id")String id,Model model) {
		System.out.println("포스트컨트롤러-포스트폼");
		
		List<PostVo> postList = postService.writeForm(id);
		model.addAttribute("postList",postList);
		return "blog/admin/blog-admin-write";
	}
		
	@RequestMapping("/{id}/admin/writeinsert")
	public String writeinsert(@PathVariable("id") String id, @ModelAttribute PostVo postVo) {
		System.out.println("[포스트컨트롤러-포스트저장]");
			
		System.out.println(postVo);
		postService.writeinsert(postVo);

		return "blog/admin/blog-admin-write";
	}
}
