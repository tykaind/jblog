package com.javaex.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	
	/***** 회원가입 등록 & 블로그생성 *****/
	public int join(UserVo userVo) {
		System.out.println("Service-조인");
		int count = userDao.join(userVo);
		
		
		Map<String, Object> blogMap = new HashMap<String, Object>();
		blogMap.put("id", userVo.getId()); 
		blogMap.put("blogTitle", userVo.getUserName() +"의 블로그입니다"); 
		blogMap.put("logoFile", "spring-logo.jpg");
	 
		userDao.joinBlog(blogMap);
		
		return count;
	}
	
	/***** 아이디중복체크 *****/
	public boolean idCheck(String id) {
		System.out.println("Service-아이디중복체크");
		
		String idCheck = userDao.idCheck(id);
		
		if(idCheck == null) {
			return true;
		}
		return false;
	}
	/***** 로그인 *****/
	public UserVo login(UserVo userVo) {
		System.out.println("Service-로그인");

		return userDao.login(userVo);
	}
	
}
