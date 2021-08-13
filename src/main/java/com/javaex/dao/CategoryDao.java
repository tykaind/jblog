package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	SqlSession sqlSession;

	public List<CategoryVo> categoryForm(String id) {
		System.out.println("카테고리다오-폼정보불러오기");
		List<CategoryVo> categoryList = sqlSession.selectList("category.categoryForm", id);
		return categoryList;
	}
	
	public int categoryInsert(CategoryVo categoryVo) {
		System.out.println("카테고리다오-저장");	

		return sqlSession.insert("category.addcategory", categoryVo); 
	}
	
	public CategoryVo selectCate(int cateNo) {
		System.out.println("게스트북다오- 넘버값을 값가져오기");
		System.out.println(cateNo);
		return sqlSession.selectOne("category.selectCategory", cateNo);
	}
	
	public int catedelect(int cateNo) {
		
		return sqlSession.delete("category.catedelect",cateNo);
	}
	
}
