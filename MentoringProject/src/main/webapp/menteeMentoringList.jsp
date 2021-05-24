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



	<h1>멘티 과거 멘토링 내역</h1>
	
	<table border="1">
		<tr>
			<th>멘토이름</th>
			<th>전공이름</th>
			<th>부전공이름</th>
			<th>시작날짜</th>
			<th>시작시간</th> 
			<th>끝시간</th>
			<th>총가격</th>			
			<th>리뷰쓰러가기</th>			

		
		</tr>
		<c:forEach items="${MenteeMentoringList }" var="dto">
		<tr>
		    <td>${dto.mentorname }</td>
			<td>${dto.majorname }</td>
			<td>${dto.submajorname }</td>
			<td>${dto.startday }</td>
			<td>${dto.starttime }</td>
			<td>${dto.endtime }</td>
			<td>${dto.totalprice }</td>
			<td><a href="/MentoringProject/menteeMentoringReview.jsp?paymentpk=${dto.paymentpk }">리뷰쓰러가기</a></td>
			
			
			
		</tr>		
		</c:forEach>


	</table>
	
</body>
</html>