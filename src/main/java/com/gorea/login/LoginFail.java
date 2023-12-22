package com.gorea.login;

import java.io.IOException;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoginFail implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		if (exception instanceof BadCredentialsException
				|| exception instanceof InternalAuthenticationServiceException) {
			request.setAttribute("loginFailMsg", "아이디와 비밀번호를 확인해 주세요");
		}
		
		request.getRequestDispatcher("/WEB-INF/views/korean/user/login.jsp").forward(request, response);
	}
}
