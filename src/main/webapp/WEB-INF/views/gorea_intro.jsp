<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Go!rea</title>
</head>
<body>

	<c:if test="${!empty AccessDeniedMsg }">
		<script type="text/javascript">
		
			const msg = "${AccessDeniedMsg}";
			
		</script>
	</c:if>

<h1>INTRO 페이지</h1>
<a href="./korean/main.do"> 한국 페이지로 이동</a><br/>
<a href="./english/main.do"> 영어 페이지로 이동</a><br/>
<a href="./japanese/main.do"> 일어 페이지로 이동</a><br/>
<a href="./chinese/main.do"> 중국어 페이지로 이동</a><br/>
</body>
</html>