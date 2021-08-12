package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class CategoryDao {

	@Autowired
	SqlSession sqlSession;
	
	public int logoJoin(Map<String, Object> blogMap) {
		System.out.println("[카테고리다오-로고조인]");
		
		sqlSession.update("category.logo",blogMap);
		
		return 1;
	}
	
	public BlogVo logorecycle(String id) {
		System.out.println("카테고리다오-로고재사용");
		System.out.println("이것이 아이디값: "+id);
		return sqlSession.selectOne("category.logorecycle", id);
	}
	
}
