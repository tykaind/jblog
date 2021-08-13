package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PostVo;

@Repository
public class PostDao {

	@Autowired
	SqlSession sqlSession;
	
	public List<PostVo> writeForm(String id) {
		System.out.println("포스트다오-포스트폼");
		
		return sqlSession.selectList("post.writeForm", id);
	}
	
	//포스트 등록
	public int writeinsert(PostVo postVo) {
		
		return sqlSession.insert("post.writeinsert", postVo);
	}
}
