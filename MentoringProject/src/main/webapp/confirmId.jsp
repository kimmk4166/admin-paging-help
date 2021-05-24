<%@page import="com.project.mentoring.dao.UserSignUpDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ID Check</title>
</head>
<body>
<%
	String id = request.getParameter("userid");
	UserSignUpDao userSignUpDao = new UserSignUpDao();
	int idCheckResult = userSignUpDao.idCheck(id);
	
	if(idCheckResult == 1){%>
	<h2>이미 사용중인 ID 입니다.</h2>
<%
	}else{
%>
	<h2>사용가능한 ID 입니다.</h2>
	<%} %>
</body>
</html>