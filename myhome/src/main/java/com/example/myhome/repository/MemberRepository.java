package com.example.myhome.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.myhome.model.Member;

public interface MemberRepository extends JpaRepository<Member, Long>{
	

}
