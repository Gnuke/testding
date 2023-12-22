<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Go!rea Login Page</title>
<script src="https://kit.fontawesome.com/52f65b6106.js" crossorigin="anonymous"></script>
<!-- 부트 스트랩 -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/login/login.css">

</head>
<body>

	<c:if test="${!empty loginFailMsg }">
		<script type="text/javascript">
      
         const msg = "${loginFailMsg}";
         
      </script>
	</c:if>

	<section class="login">
		<div class="login_box">
			<div class="left">
				<div class="top_link">
					<a href="/korean/main.do"> 
					<i class="fa-regular fa-circle-right fa-rotate-180 fa-lg"></i>
					Main Page
					</a>
				</div>
				<div class="contact">
					<form action="/loginProcKr" method="post">
						<img src="/img/login/gorea_logo.png" style="width:150px">
						<input type="text" name="username" value="" placeholder="ID">
						<input type="password" name="password" value="" placeholder="PASSWORD">
						<div class="checkbox_container">
							<!-- 쿠키 유지 -->
							<label for="continue_login">로그인 유지하기 <input
								type="checkbox" id="continue_login" name="remember-me">
							</label>
							<!-- 일반로그인 -->
							<!-- 로그인 버튼 -->
							<button class="submit login_btn" type="submit">SIGN IN</button>
						</div>
						<div class="bot_link">
							<a href="/korean/join.do">SIGN UP</a>
						</div>
						<span style="color: red; text-align: center; display: block;"
							readonly>${loginFailMsg}</span>
						<div class="bot_link2">
							<span class="findid"> 아이디나 비밀번호를 잊었을 때는, <a class="bot_link" href="#">여기</a>를
								눌러주세요.
							</span>
						</div>
					</form>
				</div>
				<div class="center-button">
					<a href=" /oauth2/authorization/google" class="image-button"></a>
				</div>
			</div>
			<div class="right">
				<div class="right-text">
					<h1>Welcome to Seoul !</h1>
					<h3>Enjoy your trip</h3>
				</div>
				<div class="right-inductor"></div>
			</div>
		</div>
	</section>
</body>

</html>