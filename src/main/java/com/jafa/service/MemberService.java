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
	//회원가입
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
	//회원등급 변명
	@Transactional
	public void updateMemberType(AuthVO authVO) {
		authRepository.remove(authVO.getMemberId());//모든등급삭제
		MemberType memberType = authVO.getMemberType(); //변경할 회원등급
		MemberType[] types = MemberType.values(); //모든타입 다가져오기
		for(int i = memberType.ordinal(); i<types.length;i++) {
			AuthVO vo = AuthVO.builder()
					.memberId(authVO.getMemberId())
					.memberType(types[i])
					.ordinal(types[i].ordinal())
					.build();
			authRepository.save(vo);
		}
		
	}
 
}
