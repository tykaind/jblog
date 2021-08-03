package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.GuestbookDao;
import com.javaex.vo.GuestbookVo;

@Service
public class GuestService {

	// 필드
	@Autowired
	private GuestbookDao guestbookDao;

	/**** 리스트 출력 ****/
	public List<GuestbookVo> getGuestbookList() {

		return guestbookDao.getGuestbookList();
	}

	/**** 방명록 등록 ****/
	public void insert(GuestbookVo guestbookVo) {

		guestbookDao.insert(guestbookVo);
	}

	/**** 방명록 삭제 ****/
	public void delete(GuestbookVo guestbookVo) {

		guestbookDao.delete(guestbookVo);

	}
	
	/**** 방명록저장,게시글가져오기 ****/
	public GuestbookVo writeResultVo(GuestbookVo guestbookVo) {
		System.out.println("게스트서비스-방명록저장게시글번호가져오기");
		
		//글저장
		System.out.println(guestbookVo); //no값 없음
		int count = guestbookDao.insertGuestbookKey(guestbookVo);
		System.out.println(guestbookVo); //no값 있음
		//글가져오기(방금등록한 번호)
		int no = guestbookVo.getNo(); //방금저장한 글 번호저장
		
		GuestbookVo resultVo = guestbookDao.selectGuestbook(no);
		
		return resultVo;
	}
}