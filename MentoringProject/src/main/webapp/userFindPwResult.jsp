<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 찾기 결과</title>
</head>
<body>

<h2>당신의 비밀번호</h2>

<span> <%out.print(request.getAttribute("userpw")); %></span>



</body>
</html>