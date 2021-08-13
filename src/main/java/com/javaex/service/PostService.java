package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {

	@Autowired
	PostDao postDao;
	
	public List<PostVo> writeForm(String id) {
		System.out.println("포스트서비스-포스트폼");
		
		return postDao.writeForm(id);
	}
	
	public int writeinsert(PostVo postVo) {
		
		return postDao.writeinsert(postVo);
		
	}
}
