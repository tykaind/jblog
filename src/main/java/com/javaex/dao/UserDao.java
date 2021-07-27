package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {
	
	@Autowired
	private SqlSession sqlSession;
	
	//회원정보 1명가져오기 로그인활용
	public UserVo selectUser(UserVo userVo) {
		System.out.println("[UserDao.selectUser()]");
	
		UserVo authUser = sqlSession.selectOne("user.selectUser", userVo);
		return authUser;
	}
	
	//회원가입
	public int userjoin(UserVo userVo) {
		System.out.println("[UserDao.userjoin()]");
		
		int count = sqlSession.insert("user.userInsert", userVo);
		
		return count;
	}
	
	//수정폼 값넘겨받기
	public UserVo selectUpdate(UserVo userVo) {
		System.out.println("[UserDao.selectUpdate()]");
		
		UserVo selectUpdate = sqlSession.selectOne("user.selectUpdate", userVo);
		
		
		return selectUpdate;
	}
	
	//수정하기
	public int userUpdate(UserVo userVo) {
		System.out.println("[UserDao.userUpdate()]");
		
		int count = sqlSession.update("user.userUpdate", userVo);
		
		return count;
	}
	
	
}
