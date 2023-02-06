package com.jafa.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Setter
@Log4j
public class LoginFailureHandler implements AuthenticationFailureHandler{

	private String errorMessage;//에러메세지
	private String defaultFaliureUrl;
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		log.info("아이디나 비밀번호가 일치 하지 않음");
		
		String loginId = request.getParameter("loginId");
		
		if(exception instanceof BadCredentialsException) { //id가 일치하지 않는경우
			errorMessage = "아이디 또는 비밀번호가 일치하지 않음";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			errorMessage = "아이디 또는 비밀번호가 일치하지 않음";
		}else {
			errorMessage = "알수없는 오류입니다. 알아서하시게";
		}


		request.setAttribute("errorMessage", errorMessage);
		request.setAttribute("loginId", loginId);
		request.getRequestDispatcher(defaultFaliureUrl).forward(request, response);
	}

}
