package com.jafa.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.log4j.Log4j;
@Log4j
public class SuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		//String loginId = request.getParameter("loginId");
		String loginId = authentication.getName();//id
		log.info("로그인성공");
		log.info(loginId+"님이 로그인 함");
		
		String requestURL = request.getRequestURL().toString();
		String requestURI = request.getRequestURI().toString();
		log.info(requestURL);
		log.info(requestURI);
		response.sendRedirect(request.getContextPath());
	}

}
