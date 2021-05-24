<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기</title>
</head>
<body>
<c:if test="${ findIdResult == 0 }">
	
		<script>
		
			alert("입력하신 정보의 아이디가 없습니다. 다시 입력하시거나 회원가입 부탁드립니다.");
			
		</script>
</c:if> 
회원 ID 찾기 페이지 입니다. 

	<form action="userFindIdByEmail.do" method="post">
		<h2>이메일로 아이디 찾기</h2>
		<tr>
			<td>이름 :</td>
			<td><input type="text" name="username" placeholder="이름을 입력해주세요"></td>
		</tr>
		<tr>
			<td>이메일 :</td>
			<td><input type="email" name="useremail" placeholder="이메일을 입력해 주세요"></td>
		</tr>	
		<tr>
		
			<td><input type="submit" value="ID 찾기"></td>
		</tr>
	</form>
	
	<form action="userFindIdByPhone.do" method="post">
		<h2>핸드폰 번로 아이디 찾기</h2>
		<tr>
			<td>이름 :</td>
			<td><input type="text" name="username" placeholder="이름을 입력해주세요"></td>
		</tr>
		<tr>
			<td>번호 :</td>
			<td><input type="tel" name="userphone" placeholder="핸드폰 번호를 입력해 주세요"></td>
		</tr>
		<tr>
			<td><input type="submit" value="ID 찾기"></td>
		</tr>	
	</form>
</body>
</html>