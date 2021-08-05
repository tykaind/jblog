package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.FileupService;

@Controller
@RequestMapping(value="/fileup/")
public class FileupController {
		
		@Autowired	
		private FileupService fileupService;
	
		@RequestMapping(value="form")
		public String form() {
			System.out.println("[파일컨트롤러-폼]");
			
			return "/fileup/form";
		}
		
		@RequestMapping(value="upload")
		public String upload(Model model,@RequestParam("file") MultipartFile file) {
			System.out.println("[파일컨트롤러-업로드]");
			
			String saveName = fileupService.restore(file);
			model.addAttribute("saveName", saveName);
			return "/fileup/result";
		}
}
