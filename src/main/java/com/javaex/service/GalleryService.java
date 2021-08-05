package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.dao.GalleryDao;
import com.javaex.vo.GalleryVo;

@Service
public class GalleryService {

	@Autowired
	GalleryDao galleryDao;
	
	
	
	public List<GalleryVo> galleryList() {
		System.out.println("[갤러리서비스-갤러리리스트]");
		
		
		return galleryDao.galleryList();
	}
	
	public String upload(MultipartFile file, String content, int userNo) {
		System.out.println("[갤러리서비스-업로드]");

		String saveDir = "C:\\javaStudy\\upload\\";

		// 원파일이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName=" + orgName);

		// 확장자
		String exName = file.getOriginalFilename().substring(orgName.lastIndexOf("."));
		System.out.println("exName=" + exName);

		// 저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName=" + saveName);

		// 파일패스
		String filePath = saveDir + saveName;
		System.out.println("filePath=" + filePath);

		// 파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize=" + fileSize);

		// 파일서버 하드디스크에 저장
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

		// 파일정보를 db에 저장
		GalleryVo galleryVo = new GalleryVo(userNo,content,filePath,orgName,saveName,fileSize);
		
		galleryDao.upload(galleryVo);
		
		return "";
	}
	
	public int delect(int no) {
		System.out.println("갤러리서비스-삭제");
		
		int count = galleryDao.delect(no);
		
		return count;
	}
	
	
	
}
