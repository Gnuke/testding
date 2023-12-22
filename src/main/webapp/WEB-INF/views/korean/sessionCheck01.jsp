<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="org.springframework.security.core.userdetails.UserDetails"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.context.SecurityContext"%>
    
<%

	
	// SecurityContextHolder를 사용하여 현재 사용자의 보안 컨텍스트(인증 정보)를 가져오는 간단한 예제
	
	StringBuilder sb = new StringBuilder();
	// SecurityContextHolder 는 시큐리티에서 현재 보안 컨텍스트를 제공하는 클래스
	// getContext()를 통해 현재 보안 컨텍스트 값읋 반환
	SecurityContext context = SecurityContextHolder.getContext();

	// getAuthentication() 메서드는 현재 사용자 인증 객체 를 반환
	// 여기서 인증 객체는 사용자가 제출한 아이디 , 비밀번호 를 기반으로 생성이 되며
	// 자격증명 (비밀번호) + 권한 (ROLE) + 인증여부 (성공적인 로그인) = 실제 정보 ( UserDetails 인터페이스로 구현한 객체 )
	Authentication authentication = context.getAuthentication();

	// 사용자가 null 이 아니며, isAuthenticated => 사용자가 인증이 되어있으면 참 조건
	if (authentication != null && authentication.isAuthenticated()) {
		// 사용자가 인증되어 있을 때의 로직
        // getPrincipal() 현재 사용자의 주체를 반환
        Object principal = authentication.getPrincipal();

        if (principal instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) principal;
            String username = userDetails.getUsername();
    	
    		sb.append("<h3> 로그인 ID : " + username + "</h3>");
  
		} else {
			
			sb.append("<h3>로그인되어있는 계정이 없습니다.</h3>");
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%= sb.toString() %>
</body>
</html>