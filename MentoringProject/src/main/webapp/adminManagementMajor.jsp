<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>전공 관리 페이지 입니다.</h1>
	<br>
	<br>
	<br>
	<h3>현재 전공 리스트</h3>
	<table border="0">
		<tr>
			<th>전공 관리 번호</th>
			<th>전공 이름</th>
		</tr>
		<c:forEach items="${majorList }" var="majorDto">
			<tr>
				<td>${majorDto.majorPk }</td>
				<td><a href="adminSubMajorListShowPage.do?majorpk=${majorDto.majorPk}&majorname=${majorDto.majorName}">${majorDto.majorName }</a></td>
			</tr>		
		</c:forEach>
		<tr>
			<td colspan="2"><a href="adminManagementMajorInsertPage.jsp">전공 추가</a></td>
		</tr>
	
	</table>
	


</body>
</html>