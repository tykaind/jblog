package com.javaex.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	/***** 회원가입 등록 *****/
	public int join(UserVo userVo) {
		System.out.println("Dao-조인");
		System.out.println(userVo);

	  return sqlSession.insert("user.join", userVo);
	}
	/***** 블로그생성 *****/
	public int joinBlog(Map<String, Object> blogMap) {
	
	return sqlSession.insert("blog.blogMap", blogMap); 
	}
	
	
	/***** 아이디중복체크 *****/
	public String idCheck(String id) {
		System.out.println("Dao-아이디중복체크");
		return sqlSession.selectOne("user.idCheck",id);
	}
	
	/***** 로그인 *****/
	public UserVo login(UserVo userVo) {
		System.out.println("Dao-로그인");
		UserVo dd = sqlSession.selectOne("user.login", userVo);
		
		System.out.println("방금방꺼내온: "+dd);
		return dd;
	}
}
