package com.jafa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@RequestMapping("/member")
@Controller
public class MemberCotroller {
	
	@RequestMapping("/login")
	public String loginForm() {
		return "member/login";
	}
	@GetMapping("/all")
	public void doAll() {
		//모든사용자
	}
	@GetMapping("/member")
	public void doMember() {
		//로그인 사용자 허용
	}
	@GetMapping("/admin")
	public void doAdmin() {
		//관리자만 허용
	}
	//접근거부처리
	@GetMapping("/accessError")
	public void accessError() {
		
	}
	
}
