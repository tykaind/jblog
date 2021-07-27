package com.javaex.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.UserService;
import com.javaex.vo.UserVo;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	
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

		UserVo authUser = userService.getUser(userVo);
		
		if(authUser != null) {
			System.out.println("[로그인성공]");

			session.setAttribute("authUser", authUser);

			return "redirect:/main";
		}else {
			System.out.println("[로그인실패]");
			
			return "redirect:/user/loginForm?result=fail";
		}
	}
	
	/********** 회원가입폼 **********/
	@RequestMapping("/user/joinForm")
	public String joinForm() {
		System.out.println("[UserController.joinForm()]");
		
		return "user/joinForm";
	}
	
	/*********** 회원가입 ***********/
	@RequestMapping("/user/join")
	public String join(@ModelAttribute UserVo userVo) {
		System.out.println("[UserController.join()]");
		System.out.println(userVo);
		userService.userjoin(userVo);
		
		return "user/joinOk";
	}
	/*********** 수정폼 ***********/
	@RequestMapping("/user/selectUpdate")
	public String selectUpdate(@ModelAttribute UserVo userVo ,Model model) {
		System.out.println("[UserController.userUpdateForm()]");
		
		UserVo selectUpdate = userService.selectUpdate(userVo);
		model.addAttribute("selectUpdate", selectUpdate);
		return "user/modifyForm";
	}
	
	/************ 수정 ************/
	@RequestMapping("/user/userUpdate")
	public String userUpdate(@ModelAttribute UserVo userVo, HttpSession session) {
		System.out.println("[UserController.userUpdate()]");
		
		userService.userUpdate(userVo);
		return "redirect:/main";
	}
}
