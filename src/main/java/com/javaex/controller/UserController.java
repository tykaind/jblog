package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.dao.UserDao;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserDao userDao;
	
	
	/************ 로그인폼 ************/
	@RequestMapping("/user/loginForm")
	public String loginForm() {
		System.out.println("[UserController.loginForm()]");
		
		return "user/loginForm";
	}
	
	/************* 로그인 *************/
	@RequestMapping("/user/login")
	public String login(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("[UserController.login()]");

		UserVo authUser = userDao.selectUser(userVo);
		if(authUser != null) {
			System.out.println("[로그인성공]");
			session.setAttribute("authUser", authUser);
			return "redirect:/main";
		}else {
			System.out.println("[로그인실패]");
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	
}
