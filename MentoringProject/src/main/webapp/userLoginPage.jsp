<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 페이지</title>
<link rel="stylesheet" href="css/components/loginPage.css">
</head>
<body>
	<c:if test="${ loginResult == -1 || loginResult == 0 }">
	
		<script>
		
			alert("아이디 혹은 비밀번호가 틀렸습니다.");
			
		</script>
	</c:if> 

		  <div class="cont">
	        <div class="demo">
	          <div class="login">
	            <div class="login__check">
	                <span>Login</span><br>
	                <span>to</span><br>
	                <span>Take your Time</span>
	            </div>
	            <form action="userLoginPage.do" method="post" name="loginForm" onsubmit="">
	                <div class="login__form">
	                <div class="login__row">
	                    <svg class="login__icon name svg-icon" viewBox="0 0 20 20">
	                    <path d="M0,20 a10,8 0 0,1 20,0z M10,0 a4,4 0 0,1 0,8 a4,4 0 0,1 0,-8" />
	                    </svg>
	                    <input type="text" class="login__input name" placeholder="UserId" name="userid"/>
	                </div>
	                <div class="login__row">
	                    <svg class="login__icon pass svg-icon" viewBox="0 0 20 20">
	                    <path d="M0,20 20,20 20,8 0,8z M10,13 10,16z M4,8 a6,8 0 0,1 12,0" />
	                    </svg>
	                    <input type="password" class="login__input pass" placeholder="Password" name= "userpw"/>
	                </div>
	                <input type="submit" class="login__submit" value="Login"/>
	                <p class="login__signup">아직 회원이 아니신가요? &nbsp;<a href="userSignUpPage.jsp">회원가입하기</a></p>
	                <p class="login__signup login__findIdPw">ID 를 잃어버리셨나요? &nbsp;<a href="userFindId.jsp"> Id 찾기</a></p>
	                <p class="login__signup login__findIdPw">PW 를 잃어버리셨나요? &nbsp;<a href="userFindPw.jsp"> PW 찾기</a></p>
	                </div>
	            </form>
	          </div>
	          </div>
	     	</div>

</body>
</html>