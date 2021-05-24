<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>
<body>
	<h2>유저리스트 출력</h2>
	<table border="0" >
		<tr>
			<th>유저 ID</th>
			<th>유저 이름</th>
			<th>유저 phone</th>
			<th>유저 email</th>
			<th>멘티 / 멘토</th>
			<th>유저 가입 날짜</th>
			<th>유저 탈퇴 날짜</th>
		</tr>
		<c:forEach items="${userList }" var="userDto">
			<tr>
				<td>${userDto.userId }</td>
				<td>${userDto.userName }</td>
				<td>${userDto.userPhone }</td>
				<td>${userDto.userEmail }</td>
				<td>${userDto.userCheck }</td>
				<td>${userDto.userInDate }</td>
				<td>${userDto.userOutDate }</td>
			
			</tr>		
		</c:forEach>
	</table>
	<table>
		<tr>
			<td colspan="4" align="center">
			<!-- 페이징 부분 -->
			<c:forEach items="${pageList }" var="page"><!-- 유저리스트를 불러오기  -->
				<a href="adminUserListShowPage.do?page=${page }">${page}</a>
			</c:forEach>
			</td>
		</tr>
	</table>
</body>
</html>