package com.javaex.dao;

import java.util.Map;

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
	
	/*블로그타이틀,로고수정*/
	public int logoJoin(Map<String, Object> blogMap) {
		System.out.println("[카테고리다오-로고조인]");
		
		sqlSession.update("blog.logo",blogMap);
		
		return 1;
	}
	/*기존로고쓸경우*/
	public BlogVo logorecycle(String id) {
		System.out.println("카테고리다오-로고재사용");
		System.out.println("이것이 아이디값: "+id);
		return sqlSession.selectOne("blog.logorecycle", id);
	}
}
