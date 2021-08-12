package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.BlogVo;

@Repository
public class BlogDao {

	@Autowired
	private SqlSession sqlSession;
	
	public BlogVo myblog(String id) {

		System.out.println("블로그다오 유저넘버값: "+id);
		BlogVo o = sqlSession.selectOne("blog.myblogList", id);
	return o;
	}
}
