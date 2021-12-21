package com.example.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.myhome.model.Member;
import com.example.myhome.model.Role;
import com.example.myhome.repository.MemberRepository;

@Service
public class MemberService {
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Member register(Member member) {
		String encodedPassword = passwordEncoder.encode(member.getPw());
		member.setPw(encodedPassword);
		member.setEnabled("Y");
		Role role = new Role();
		int i = 11;
		Long x = Long.valueOf(i);
		role.setRno(x);
		member.getRoles().add(role);
		return memberRepository.save(member);
	}
}
