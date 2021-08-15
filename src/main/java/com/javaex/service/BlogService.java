package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;

@Service
public class BlogService {

	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;

	public BlogVo myblog(String id) {
		System.out.println("블로그컨트롤러-마이블로그");
		
	return blogDao.myblog(id);
	}

	
	/*블로그타이틀, 로고 수정*/
	public int logoJoin(String id, String blogTitle, MultipartFile file) {
		System.out.println("카테고리서비스-로고조인");
		String saveDir = "C:\\javaStudy\\upload\\";
		String orgfileName = file.getOriginalFilename();
		String filePath = saveDir + orgfileName;
		

		try {
			byte[] fileData = file.getBytes();
			OutputStream out = new FileOutputStream(filePath);
			BufferedOutputStream bout = new BufferedOutputStream(out);

			bout.write(fileData);
			bout.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Map<String, Object> logoMap = new HashMap<String, Object>();
		logoMap.put("id", id); 
		logoMap.put("blogTitle", blogTitle); 
		logoMap.put("file", orgfileName);
		
		blogDao.logoJoin(logoMap);
		return 1;
	}
	
	
	
	/*기존로고 재사용 등록*/
	public int logoJoinrecyle(String id, String blogTitle, String logoName) {
		System.out.println("카테고리서비스-로고조인재사용");
		
		Map<String, Object> logoMap = new HashMap<String, Object>();
		logoMap.put("id", id); 
		logoMap.put("blogTitle", blogTitle); 
		logoMap.put("file", logoName);
		
		blogDao.logoJoin(logoMap);
		return 1;
	}
	
	
	
	/*기존로고 재사용 하기위한 기존로고 이름 가져오기*/
	public BlogVo logorecycle(@RequestParam("id") String id) {
		System.out.println("카테고리서비스-로고재사용");
		
		return blogDao.logorecycle(id);
	}
	
	public List<CategoryVo> mainCategory(String id) {
		System.out.println("서비스메인카테고리");
		List<CategoryVo> categoryVo = categoryDao.mainCategory(id);
		
		return categoryVo;
	}
}
