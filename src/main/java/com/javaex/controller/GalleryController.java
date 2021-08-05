package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.GalleryService;
import com.javaex.vo.GalleryVo;

@Controller
public class GalleryController {
	
	@Autowired
	GalleryService galleryService;	
	
	@RequestMapping("/gallery/list")
	public String list(Model model) {
		System.out.println("[갤러리컨트롤러-리스트]");
		
		List<GalleryVo> galleryList = galleryService.galleryList();
		System.out.println(galleryList);
		model.addAttribute("galleryList", galleryList);
		return "/gallery/list";
	}
	
	@RequestMapping("/gallery/upload")
	public String upload(@RequestParam("content") String content,@RequestParam("file") MultipartFile file,@RequestParam("userNo") int userNo) {
		System.out.println("[갤러리컨트롤러-업로드]");
		
		String saveName = galleryService.upload(file, content, userNo);

		return "redirect:/gallery/list";
	}
	
	@ResponseBody
	@RequestMapping("/gallery/delect")
	public int delect(@RequestParam("no") int no) {
		System.out.println("[갤러리컨트롤러-삭제]");

		int count = galleryService.delect(no);
		
		return count;
	}
	@ResponseBody
	@RequestMapping("/gallery/selectOne")
	public GalleryVo selectOne(@RequestParam("no") int no,Model model) {
	
		GalleryVo galleryVo = galleryService.selectOne(no);
		model.addAttribute(galleryVo);
		System.out.println(galleryVo);
	return galleryVo;
	}
	
}
