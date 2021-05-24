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


			<h3>내가 작성한 리뷰 리스트</h3>
	<table border="1">
		<tr>
			<th>멘토이름</th>
			<th>전공이름</th>
			<th>프로덕트타이틀</th>
			<th>리뷰제목</th>
			
		
		</tr>
		<c:forEach items="${MenteeReviewList }" var="dto">
		<tr>
		    <td>${dto.mentorname }</td>
			<td>${dto.majorname }</td>
			<td>${dto.title }</td>
			<td>${dto.reviewtitle }</td>
			
			<td><a href="/MentoringProject/appointment.do?productpk=${dto.productpk }">보러가기</a></td>
			
			
			
		</tr>		
		</c:forEach>


	</table>

</body>
</html>