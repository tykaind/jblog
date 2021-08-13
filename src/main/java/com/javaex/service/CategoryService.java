package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	
	@Autowired
	CategoryDao categoryDao;

	
	public List<CategoryVo> categoryForm(String id) {
		System.out.println("카테고리서비스-폼정보불러오기");
		
		List<CategoryVo> categoryList =  categoryDao.categoryForm(id);
		
		return categoryList;
	}
	
	
	/*카테고리저장 키값가져오기*/
	public CategoryVo categoryInsert(CategoryVo categoryVo) {
		System.out.println("카테고리서비스-등록");
		
		categoryDao.categoryInsert(categoryVo);
		
		int cateNo = categoryVo.getCateNo();
		System.out.println("값좀넘어와라!: "+cateNo);
		CategoryVo addcate = categoryDao.selectCate(cateNo);
		
		return addcate;
	}
	
	public int catedelect(int cateNo) {
		
		int count = categoryDao.catedelect(cateNo);

		return count;
	}
}
