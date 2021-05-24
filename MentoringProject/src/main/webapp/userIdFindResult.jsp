<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID 찾기 결과</title>
</head>
<body>

	<h2>ID 찾기 결과 입니다.</h2>
	
	<span>당신의 아이디는</span><br>
	<span><%out.println(request.getAttribute("userid")); %></span>
	
	<table>
		<tr>
			<td><a href="userLoginPage.jsp">로그인 페이지로 이동</a></td>
			<td><a href="userFindPw.jsp"> PW 찾기 페이지로 이동</a></td>
		</tr>
	</table>

</body>
</html>