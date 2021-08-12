package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	/***** 회원가입 폼 *****/
	@RequestMapping("/user/joinForm")
	public String joinForm() {
		System.out.println("controller-회원가입폼");
		
		return "user/joinForm";
	}
	
	/****** 로그아웃 ******/
	@RequestMapping("/user/logout")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return "redirect:/main/index";
	}
	
	
	/***** 회원가입 등록 & 블로그생성*****/
	@RequestMapping("/user/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("controller-조인");
		
		userService.join(userVo);
		return "user/joinSuccess";
	}
	
	/***** 아이디중복체크 *****/
	@ResponseBody
	@RequestMapping("/user/idCheck")
	public boolean idCheck(@RequestParam("id")String id) {
		boolean state = userService.idCheck(id);
		return state;
	}
	
	/***** 로그인폼 *****/
	@RequestMapping("/user/loginForm")
	public String loginForm() {
		System.out.println("controller-로그인폼");
		
		return "user/loginForm";
	}
	
	/***** 로그인 *****/
	@RequestMapping("/user/login")
	public String login(@ModelAttribute UserVo userVo,HttpSession session) {
		System.out.println("controller-로그인");
		UserVo authUser = userService.login(userVo);

		if(authUser != null) {
			System.out.println("[로그인성공]");
			session.setAttribute("authUser", authUser);

			return "redirect:/main/index";
		}else {
			System.out.println("[로그인실패]");
			
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
}
