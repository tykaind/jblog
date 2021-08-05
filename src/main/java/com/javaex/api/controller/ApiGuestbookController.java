package com.javaex.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.GuestService;
import com.javaex.vo.GuestbookVo;

@Controller
@RequestMapping(value="/api/guestbook/")
public class ApiGuestbookController {

	@Autowired
	private GuestService guestService;
	
	//ajax 리스트 가져오기
	@ResponseBody
	@RequestMapping(value= "list")
	public List<GuestbookVo> List() {
		System.out.println("에이작스컨트롤러-리스트");
		
		List<GuestbookVo> guestbookList = guestService.getGuestbookList();
		System.out.println(guestbookList);
		
		return guestbookList;
	}
	
	//ajax 방명록 저장
	@ResponseBody
	@RequestMapping(value= "write")
	public GuestbookVo write(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("에아작스컨트롤러-등록");
		
		GuestbookVo resultVo = guestService.writeResultVo(guestbookVo);
		return resultVo;
	}
	
	//ajax 방명록 삭제
	@ResponseBody
	@RequestMapping(value= "remove")
	public int remove(@ModelAttribute GuestbookVo guestbookVo) {
		System.out.println("에아작스컨트롤러-삭제");
		
		int count = guestService.delete(guestbookVo);
		
		return count;
	}
	
	
	
}
