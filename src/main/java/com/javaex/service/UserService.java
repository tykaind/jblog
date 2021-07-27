package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	//로그인 (사용자정보 가져오기)
	public UserVo getUser(UserVo userVo) {
		System.out.println("[UserService.getUser()]");
		
		UserVo authUser = userDao.selectUser(userVo);
		
		return authUser;
	}
	//회원가입
	public int userjoin(UserVo userVo) {
		System.out.println("[UserService.join()]");
		
		int count  = userDao.userjoin(userVo);
		
		return count;
	}
	
	//수정폼 값넘겨받기
	public UserVo selectUpdate(UserVo userVo) {
		System.out.println("[UserService.selectUpdate()]");
		
		UserVo selectUpdate = userDao.selectUpdate(userVo);
		
		return selectUpdate;
	}
	
	//수정하기
	public int userUpdate(UserVo userVo) {
		System.out.println("[UserService.userUpdate()]");
		
		int count = userDao.userUpdate(userVo);
		
		return count;
	}
	
}
