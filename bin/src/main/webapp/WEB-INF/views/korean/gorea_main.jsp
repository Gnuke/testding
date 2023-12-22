<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- 페이지 어딘가에 추가 -->
<script>
    function logout() {
        // 로그아웃 URL로 이동하거나 로그아웃 처리를 위한 기본 동작을 수행합니다.
        window.location.href = '/logout.do';
    }
</script>

</head>
<body>
한국어 메인페이지<br/>

	<div class="login_box">
	    <c:if test="${empty SPRING_SECURITY_CONTEXT}">
	        <a href="/korean/login.do"><span>로그인</span></a>
	    </c:if>
	    
	    <c:if test="${not empty SPRING_SECURITY_CONTEXT}">
	        <c:set var="role" value="${SPRING_SECURITY_CONTEXT.authentication.principal.gorea_UserTO.go_user_role}" />
	     
	        <c:choose>
	            <c:when test="${role eq 'ROLE_USER'}">
	                <h1><span class="role" data-nickname="${role }">일반 회원</span><br/></h1>
	                	<a href="/user/korean/mypage.do">마이페이지로 이동</a><br/>
	            </c:when>
	            <c:when test="${role eq 'ROLE_ADMIN'}">
	                <h1><span class="role" data-nickname="${role }">관리자</span><br/></h1>
	                	<a href="/user/korean/mypage.do">마이페이지로 이동</a><br/>
	                	<a href="/admin/adminpage.do">관리자페이지로 이동</a><br/>
	            </c:when>
	            <c:otherwise>
	                <!-- 다른 역할에 해당하는 경우 -->
	            </c:otherwise>
	        </c:choose>
	    </c:if>
	</div>

</body>
</html>