package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.vo.BlogVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;

	public BlogVo myblog(String id) {
		System.out.println("블로그컨트롤러-마이블로그");
		
	return blogDao.myblog(id);
	}

}
