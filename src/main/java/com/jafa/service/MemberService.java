package com.jafa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jafa.domain.AuthVO;
import com.jafa.domain.MemberType;
import com.jafa.domain.MemberVO;
import com.jafa.repository.AuthRepository;
import com.jafa.repository.MemberRepository;
@Service
public class MemberService {
	
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	AuthRepository authRepository;
	@Autowired
	PasswordEncoder passwordEncoder; //유효성 검사 이후에 하는게 좋음
	
	@Transactional
	public void join(MemberVO vo) {
		vo.setPassword(passwordEncoder.encode(vo.getPassword())); // 가입시키기전에 비밀번호 암호화 
		memberRepository.save(vo);
		AuthVO ayuthVO = AuthVO.builder()
				.memberId(vo.getMemberId())
				.memberType(MemberType.ROLE_ASSOCIATE_MEMBER)
				.ordinal(MemberType.ROLE_ASSOCIATE_MEMBER.ordinal())
				.build();
		authRepository.save(ayuthVO);
	
	}
 
}
