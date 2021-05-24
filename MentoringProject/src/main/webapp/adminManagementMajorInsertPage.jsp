<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>전공 추가 페이지 </title>
</head>
<body>
	
	<c:choose>
		<c:when test="${majorInsertResult == 1 }">
			<script>
		
			alert("전공 추가 성공!");
			
			</script>	
		</c:when>
		<c:when test="${majorInsertResult == 0}">
			<script>
		
			alert("전공 추가 실패!");
			
			</script>	
		</c:when>
	</c:choose>
	 

	<h2>전공 추가 페이지 입니다.</h2>
	<form action="adminInsertMajor.do" method="post">
		<table>
			<tr>
				<td>추가할 전공 이름</td>
			</tr>
			<tr>
				<td><input type="text" name="majorname"></td>
			</tr>
			<tr>
				<td><input type="submit" value="추가하기"></td>
			</tr>
		
		</table>
	</form>
	<form action="adminMajorListShowPage.do" method="post">
		<input type="submit" value="전공 추가 완료 / 돌아가기">
	</form>
</body>
</html>