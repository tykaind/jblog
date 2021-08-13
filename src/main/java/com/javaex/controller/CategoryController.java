package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Controller
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private BlogService blogService;
	
	@RequestMapping("/{id}/admin/cate")
	public String categoryForm(Model model,@PathVariable("id")String id) {
		System.out.println("카테컨트롤러-폼정보불러오기");
		
		BlogVo blogVo = blogService.myblog(id);
		model.addAttribute("blogVo",blogVo);
		
		List<CategoryVo> categoryList = categoryService.categoryForm(id);
		System.out.println(categoryList);
		
		model.addAttribute("categoryList", categoryList);
	return "blog/admin/blog-admin-cate";
	}
	
	@ResponseBody
	@RequestMapping("/{id}/admin/cateinsert")
	public CategoryVo categoryInsert(@ModelAttribute CategoryVo categoryVo) {
		System.out.println("등록폼");
		CategoryVo addcategory = categoryService.categoryInsert(categoryVo);
		
		return addcategory;
	}
	
	@ResponseBody
	@RequestMapping("/admin/catedelect")
	public int catedelect(@RequestParam("cateNo") int cateNo) {
		System.out.println("삭제폼");
		System.out.println(cateNo);
		int count = categoryService.catedelect(cateNo);
		
		return count;
	}
	
	@ResponseBody
	@RequestMapping("/{id}/admin/categoryList")
	public List<CategoryVo> categoryList(Model model, @PathVariable("id") String id) {
		System.out.println("[CategoryController.adminCategory()]");
		
		BlogVo blogVo = blogService.myblog(id);
		model.addAttribute("blogVo",blogVo);
		
		List<CategoryVo> categoryList = categoryService.categoryForm(id);
		System.out.println(categoryList);
		
		
		return categoryList;
	}
	

}
