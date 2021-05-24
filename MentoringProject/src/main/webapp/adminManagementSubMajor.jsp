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
	
	<h2><%=request.getParameter("majorname") %> 전공 의 세부전공 관리 페이지 입니다.</h2>
	
	<table border="0">
		<tr>
			<th>관리번호</th>
			<th>이름</th>
		</tr>
		<c:forEach items="${subMajorList }" var="subMajorDto">
			<tr>
				<td>${subMajorDto.submajorPk }</td>
				<td>${subMajorDto.submajorName }</td>
			</tr>		
		</c:forEach>
		<tr>
			<td colspan="2"><a href="adminManagementSubMajorInsertPage.jsp?majorpk=<%=request.getParameter("majorpk") %>&majorname=<%=request.getParameter("majorname")%>">세부전공 추가</a></td>
		</tr>
	
	</table>
	
	
</body>
</html>