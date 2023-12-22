package com.gorea.login;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LogoutHandler implements LogoutSuccessHandler {

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {

		String language = determineLanguageFromRequest(request);
		String redirectUrl;

		if ("korean".equals(language)) {
			redirectUrl = "/korean/main.do";
		} else if ("english".equals(language)) {
			redirectUrl = "/english/main.do";
		} else if ("japanese".equals(language)) {
			redirectUrl = "/japanese/main.do";
		} else if ("chinese".equals(language)) {
			redirectUrl = "/chinese/main.do";
		} else {
			// 기본적으로 설정할 URL
			redirectUrl = "/korean/main.do";
		}

		response.sendRedirect(request.getContextPath() + redirectUrl);
	}

	private String determineLanguageFromRequest(HttpServletRequest request) {
		
		String language = request.getParameter("language");
		
		if (language != null && !language.isEmpty()) {
			return language;
		} else {
			return "korean"; // 기본값 설정
		}
	}
}
