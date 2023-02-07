package com.jafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.jafa.domain.MemberDetail;
import com.jafa.domain.MemberVO;
import com.jafa.repository.MemberRepository;

public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private MemberRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String memberId) throws UsernameNotFoundException {
		MemberVO vo = repository.read(memberId);
		
		
		return new MemberDetail(vo);
	}

}
