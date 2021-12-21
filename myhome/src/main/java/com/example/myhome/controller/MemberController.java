package com.example.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.myhome.model.Member;
import com.example.myhome.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("/register")
	public String registerView()throws Exception{
		return "/board/register";
	}
	
	@PostMapping("/register")
	public String register(Member member) throws Exception{

		memberService.register(member);
	return "/board/login";	
	}
}
