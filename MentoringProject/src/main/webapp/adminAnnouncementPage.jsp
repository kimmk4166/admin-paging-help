<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
</head>
<body>
	<h3>공지사항 List</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list}" var="dto">
		<tr>
			<td>${dto.noticepk }</td>
			<td><a href="AdminAnnouncementContent.do?noticepk=${dto.noticepk }">${dto.noticetitle }</a></td>
			<td>${dto.indate }</td>
		</tr>
		</c:forEach>
	</table>
	<table>
		<tr>
				<td colspan="4" align="center">
 					<c:forEach items="${pageList }" var="page">
						<a href="AdminAnnouncementList.do?page=${page }">${page}</a>
					</c:forEach>
				</td>
			</tr>
		<tr>
			<td colspan="5" align="right"><a href="AdminAnnouncementWrite_view.do">글작성</a></td>
		</tr>	
	</table>
</body>
</html>