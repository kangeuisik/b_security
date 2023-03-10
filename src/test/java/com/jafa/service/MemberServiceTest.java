package com.jafa.service;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.domain.AuthVO;
import com.jafa.domain.MemberType;
import com.jafa.domain.MemberVO;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-config/root-context.xml",
		"classpath:spring-config/security-context.xml",
		"classpath:spring-config/servlet-context.xml"
})
@WebAppConfiguration
public class MemberServiceTest {
	
	@Autowired
	MemberService service;
	//회원가입테스트
	@Test
	@Ignore
	public void test() {
		MemberVO vo = MemberVO.builder()
				.memberId("kang")
				.password("1234")
				.email("kang@naver.com")
				.build();
		service.join(vo);
	}
	
	//등급변경
	@Test
	public void test2() {
		service.updateMemberType(new AuthVO("admin",MemberType.ROLE_ADMIN));
	}
}
