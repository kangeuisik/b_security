package com.jafa.repository;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.jafa.domain.MemberVO;

import lombok.extern.log4j.Log4j;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:spring-config/root-context.xml",
		"classpath:spring-config/security-context.xml",
		"classpath:spring-config/servlet-context.xml"
})
@WebAppConfiguration
@Log4j
public class MemberRepositoryTest {
	@Autowired
	MemberRepository repository;
	
	@Test
	public void test() {
		MemberVO id = repository.read("kang");
		log.info(id);
	}

}
