<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Gorea Join</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="/css/join/join.css">
</head>

<body>

	<!-- 로그인 실패시 -->
	<c:if test="${!empty loginFailMsg }">
		<script type="text/javascript">
      
         const msg = "${loginFailMsg}";
         
      </script>
	</c:if>

	<div class="container">
		<div class="input-form-backgroud row">
			<div class="input-form col-md-12 mx-auto">
				<h4 class="mb-3">SIGN UP</h4>
				<form class="validation-form" novalidate="" action="/korean/joinOk.do" method="post">
					<div class="mb-3">
						<label for="username"></label>
						<div class="input-group">
							<input type="text" class="form-control" id="username" name="username"
								placeholder="아이디" required="">
							<button class="btn btn-primary2" type="button"
								onclick="checkUsername()">중복
								확인</button>
						</div>
						<div class="invalid-feedback">아이디를 입력해주세요.</div>
					</div>

					<!-- 비밀번호 입력 필드 -->
					<div class="mb-3">
						<label for="password"></label> <input type="password" name="password"
							class="form-control" id="password" placeholder="비밀번호를 8자 이상"
							required="" minlength="8">
						<div class="invalid-feedback">비밀번호를 8자 이상 입력해주세요.</div>
					</div>

					<!-- 비밀번호 확인 입력 필드 -->
					<div class="mb-3">
						<label for="confirm-password"></label> <input type="password"
							class="form-control" id="confirm-password" placeholder="비밀번호 확인"
							required="" minlength="8">
						<div class="invalid-feedback" id="password-confirm-feedback">
							비밀번호가 일치하지 않습니다.</div>
					</div>
					<div class="row">
						<div class="col-md-6 mb-3">
							<label for="firstName"></label> <input type="text"
								class="form-control" id="firstName" name="go_user_firstname" placeholder="성" value=""
								required="">
							<div class="invalid-feedback">이름을 입력해주세요.</div>
						</div>
						<div class="col-md-6 mb-3">
							<label for="lastName"></label> <input type="text"
								class="form-control" id="lastName" name="go_user_lastname" placeholder="이름" value=""
								required="">
							<div class="invalid-feedback">성을 입력해주세요.</div>
						</div>
					</div>

					<div class="mb-3">
						<label for="nickname"></label>
						<div class="input-group">
							<input type="text" class="form-control" id="nickname" name="go_user_nickname"
								placeholder="닉네임" required="">
							<button class="btn btn-primary2" type="button"
								onclick="checkNickname()">중복
								확인</button>
						</div>
						<div class="invalid-feedback">닉네임을 입력해주세요.</div>
					</div>

					<div class="mb-3">
						<label for="email"></label> <input type="email"
							class="form-control" id="email" name="go_user_mail" placeholder="you@example.com"
							required="">
						<div class="invalid-feedback">이메일을 입력해주세요.</div>
					</div>
					
					<div class="mb-3">
						<select id="country" name="go_user_nation">
    					<option value="대한민국">대한민국 (South Korea)</option>
    					<option value="미국">미국 (USA)</option>
    					<option value="일본">일본 (Japan)</option>
    					<option value="중국">중국 (China)</option>
						</select>
					</div>
					
					<div class="custom-control custom-checkbox">
						<input type="checkbox" class="custom-control-input" id="aggrement"
							required=""> <label class="custom-control-label"
							for="aggrement">개인정보 수집 및 이용에 동의합니다.</label>
					</div>
					<div class="mb-4"></div>
					<button class="btn btn-primary btn-lg btn-block" type="submit">가입
						완료</button>
				</form>
			</div>
		</div>
	</div>
	<script>
        // 아이디 중복 확인 함수
        function checkUsername() {
            // TODO: 서버에 아이디 중복 확인 요청을 보내는 로직 구현
            console.log("아이디 중복 확인 로직 필요");
        }

        // 닉네임 중복 확인 함수
        function checkNickname() {
            // TODO: 서버에 닉네임 중복 확인 요청을 보내는 로직 구현
            console.log("닉네임 중복 확인 로직 필요");
        }

        // 비밀번호 일치 확인
        document.getElementById('confirm-password').oninput = function() {
            const password = document.getElementById('password').value;
            const confirmPassword = document.getElementById('confirm-password').value;
            const feedback = document.getElementById('password-confirm-feedback');

            if (password !== confirmPassword) {
                feedback.style.display = 'block';
            } else {
                feedback.style.display = 'none';
            }
        };
    </script>
	<!-- Bootstrap 및 폼 유효성 검증 스크립트 -->
	<script>
        window.addEventListener('load', () => {
            const forms = document.getElementsByClassName('validation-form');

            Array.prototype.filter.call(forms, (form) => {
                form.addEventListener('submit', function (event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                        // 폼 검증 실패 시 피드백 표시
                        form.classList.add('was-validated');
                    } else {
                    }
                }, false);
            });
        }, false);
    </script>
</body>
</html>