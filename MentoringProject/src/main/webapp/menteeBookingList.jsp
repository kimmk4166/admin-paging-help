<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
table{border-spacing:20px; 
text-align:center;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	
			<h3>나의 예약대기 내역</h3>
	<table border="0">

		
		<tr>
		<td colspan="8"></td>
		<td>
		전부보기<input type="radio" name="booking" value="null" onclick="getClick(event)" th:checked="${empty param.booking ? 'checked' : ''}">
		</td>
		<td>
		예약대기<input type="radio" name="booking" value="wait" onclick="getClick(event)" th:checked="${param.booking eq 'wait' ? 'checked' : ''}">
		</td>
		<td>
		예약성공<input type="radio" name="booking" value="complite" onclick="getClick(event)" th:checked="${param.booking eq 'complite' ? 'checked' : ''}">
		</td>
		<td>
		예약취소<input type="radio" name="booking" value="cancel" onclick="getClick(event)" th:checked="${param.booking eq 'cancel' ? 'checked' : ''}">
		</td>
		</tr>
		<tr>
			<th style="visibility:hidden">pk</th>
			<th>멘토이름</th>
			<th>전공이름</th>
			<th>부전공이름</th>
			<th>시작날짜</th>
			<th>시간</th>
			<th>결제일</th>
			<th>예약취소일</th>
			<th>토큰</th>
			<th>선택</th>
			
		
		</tr>
		<c:forEach items="${MenteeBookingList }" var="dto">

		<tr>
			<td style="visibility:hidden">${dto.paymentpk }</td>
		    <td>${dto.menteename }</td>
			<td>${dto.majorname }</td>
			<td>${dto.submajorname }</td>
			<td>${dto.startday }</td>
			<td>${dto.starttime }~${dto.endtime }</td>
			<td><fmt:formatDate value="${dto.paymentpaydate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td><fmt:formatDate value="${dto.paymentcanceldate }" pattern="yyyy.MM.dd HH:mm:ss" /></td>
			<td>${dto.paymenttoken }</td>
<td><c:if test="${empty dto.paymentcanceldate }">
       <a href="/MentoringProject/menteeBookingCancel.do?paymentpk=${dto.paymentpk }">예약취소</a>
    </c:if>
</td> 
		
			
			
			
		</tr>		
		</c:forEach>
			



	</table>

</body>
<script type="text/javascript">
function getClick(event) {
		  location.href="menteeBookingList.do?booking="+event.target.value;;
	}

</script>
</html>