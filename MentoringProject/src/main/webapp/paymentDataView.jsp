<%@page import="com.project.mentoring.dto.ShareVar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <title>결제하기</title>
    <meta charset="utf-8"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
</head>
<body>
<h3>결제 데이터를 확인하세요!</h3>
	
<table>

<tr >
			<th>예약날짜</th><th>${Paymentdata.startday }</th>
</tr>
<tr >
			<th>금액</th><th>${Paymentdata.title }</th>
</tr>
<tr >
			<th>금액</th><th>${Paymentdata.totalprice }</th>
</tr>
<tr >
			<th>전공/부전공</th><th>${Paymentdata.majorname }/${Paymentdata.submajorname }</th>
</tr>
<tr >
			<th>Mentor 이름</th><th>${Paymentdata.username }</th>
</tr>

</table>
		<%
	session.setAttribute("USERNAME","username");
	
	%>
<section>
    <p>----------------------</p>
    <div><label><input type="radio" name="method" value="카드" checked/>신용카드</label></div>
    <div><label><input type="radio" name="method" value="가상계좌" checked/>가상계좌</label></div>
    <p>----------------------</p>
  <button id="payment-button" >결제하기</button>
<a href="/MentoringProject/paymentScheduleSelect.do?productpk=<%=ShareVar.productpk %>">돌아가기</a>
</section>
<script src="https://js.tosspayments.com/v1"></script>
<script>
	var totalprice = '<c:out value="${Paymentdata.totalprice }"/>';
	var title = '<c:out value="${Paymentdata.title }"/>';
	var username = '<%=session.getAttribute("USERNAME") %>';
    var tossPayments = TossPayments("test_ck_kZLKGPx4M3MLwj1E9yd8BaWypv1o");
    var button = document.getElementById("payment-button");

    var orderId = new Date().getTime();

    button.addEventListener("click", function () {
        var method = document.querySelector('input[name=method]:checked').value; // "카드" 혹은 "가상계좌"

        var paymentData = {
            amount: 5000,
            orderId: orderId,
            orderName: title,
            customerName: username,
            successUrl: window.location.origin + "/MentoringProject/paymentSuccess.do",
            failUrl: window.location.origin + "/MentoringProject/paymentfail.jsp",
        };
        
        if (method === '가상계좌') {
            paymentData.virtualAccountCallbackUrl = window.location.origin + '/jsp-sample/VirtualAccountCallback.jsp'
        }

        tossPayments.requestPayment(method, paymentData);
    });
</script>
</body>
</html>