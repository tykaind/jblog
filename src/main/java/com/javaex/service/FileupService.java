package com.javaex.service;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileupService {
	
	//@Autowired
	//FileupDao fileupDao;
	
	//파일 업로드 처리
	public String restore(MultipartFile file) {
		System.out.println("[파일업로드서비스-파일업로드");
		
		String saveDir = "C:\\javaStudy\\upload\\";
		
		//원파일이름
		String orgName = file.getOriginalFilename();
		System.out.println("orgName=" + orgName);
		
		//확장자
		String exName = file.getOriginalFilename().substring(orgName.lastIndexOf("."));
		System.out.println("exName=" + exName);
		
		//저장파일이름
		String saveName = System.currentTimeMillis() + UUID.randomUUID().toString() + exName;
		System.out.println("saveName=" +saveName);
		
		
		//파일패스
		String filePath = saveDir + saveName;
		System.out.println("filePath=" +filePath);
		
		//파일사이즈
		long fileSize = file.getSize();
		System.out.println("fileSize=" +fileSize);
		
		//파일서버 하드디스크에 저장
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
		
		//파일정보를 db에 저장 -- 과제
		
		//fileupDao.fileupload();
		
		
		
		return saveName;
	}
}
