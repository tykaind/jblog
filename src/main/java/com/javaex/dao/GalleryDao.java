package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.GalleryVo;

@Repository
public class GalleryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public List<GalleryVo> galleryList() {
		System.out.println("갤러리다오-갤러리리스트");
		

		return sqlSession.selectList("gallery.List");
	}
	
	public int upload(GalleryVo galleryVo) {
		System.out.println("[갤러리다오-업로드]");
		
		int count = sqlSession.insert("gallery.upload",galleryVo);
		
		return count;
	}
	
	public int delect(int no) {
		System.out.println("[갤러리다오-삭제]");
		
		int count = sqlSession.delete("gallery.delect", no);
		
		return count;
	}
	
}
