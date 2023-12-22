<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<!-- 페이지 어딘가에 추가 -->
<script>
    function logout() {
        // 로그아웃 URL로 이동하거나 로그아웃 처리를 위한 기본 동작을 수행합니다.
        window.location.href = '/logout.do';
    }
</script>

</head>
<body>

<h1>My page</h1>
	<div>
	    <c:if test="${not empty SPRING_SECURITY_CONTEXT}">
	        <!-- 시큐리티 컨텍스트에서 사용자 정보를 가져옴 -->
	        <c:set var="nickname" value="${SPRING_SECURITY_CONTEXT.authentication.principal.gorea_UserTO.go_user_nickname}" />
	        <c:set var="role" value="${SPRING_SECURITY_CONTEXT.authentication.principal.gorea_UserTO.go_user_role}" />
	        <c:set var="mail" value="${SPRING_SECURITY_CONTEXT.authentication.principal.gorea_UserTO.go_user_mail}" />
	        <c:set var="nation" value="${SPRING_SECURITY_CONTEXT.authentication.principal.gorea_UserTO.go_user_nation}" />
	       
	        <!-- 저장한 변수를 사용자에게 보여주고, data-nickname 속성에도 동일한 값 지정 -->
	        <h2>유저 정보</h2>
	        NickName : <span class="nickname" data-nickname="${nickname }">${nickname }</span><br/>
	        사용자 유형 :
	        <c:choose>
	            <c:when test="${role eq 'ROLE_USER'}">
	                <span class="role" data-nickname="${role }">일반 회원</span><br/>
	            </c:when>
	            <c:when test="${role eq 'ROLE_ADMIN'}">
	                <span class="role" data-nickname="${role }">관리자</span><br/>
	            </c:when>
	            <c:otherwise>
	                <!-- 다른 역할에 해당하는 경우 -->
	            </c:otherwise>
	        </c:choose><br/>
	        mail : <span class="nickname" data-nickname="${mail }">${mail }</span><br/>
	        nation : 
	        <c:choose>
	            <c:when test="${nation eq null}">
	                <span class="role">정보 없음</span><br/>
	            </c:when>
	            <c:when test="${not empty nation}">
	                <span class="role" data-nickname="${nation }">${nation }</span><br/>
	            </c:when>
	            <c:otherwise>
	                <!-- 다른 역할에 해당하는 경우 -->
	            </c:otherwise>
	        </c:choose><br/>
	        
	        	<a href="/korean/check1.do">세션 체크1</a><br/>
	        	<a href="/korean/check2.do">세션 체크2</a><br/><br/>
	        <button type="button" class="logout" onclick="logout()">로그아웃</button>
	    </c:if>
	</div>

</body>
</html>