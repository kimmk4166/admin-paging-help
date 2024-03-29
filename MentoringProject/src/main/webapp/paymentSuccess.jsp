<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Base64"%>
<%@ page import="java.util.Base64.Encoder"%>
<%@ page import="java.net.HttpURLConnection"%>
<%@ page import="java.net.URL" %>
<%@ page import="org.json.simple.JSONObject" %>
<%@ page import="org.json.simple.parser.JSONParser" %>
<%@ page import="org.json.simple.parser.ParseException" %>
<%@ page import="java.io.OutputStream" %>
<%@ page import="java.io.InputStream" %>
<%@ page import="java.io.InputStreamReader" %>
<%@ page import="java.io.Reader" %>
<%@ page import="java.nio.charset.StandardCharsets" %>

<%
 // 결제 승인 API 호출하기 
 
  String orderId = request.getParameter("orderId");
  String paymentKey = request.getParameter("paymentKey");
  String amount = request.getParameter("amount");

  String secretKey = "test_ak_JQbgMGZzorzYpJ1D4XkVl5E1em4d" + ":";
  
  Encoder encoder = Base64.getEncoder(); 
  byte[] encodedBytes = encoder.encode(secretKey.getBytes("UTF-8"));
  String authorizations = "Basic "+ new String(encodedBytes, 0, encodedBytes.length);
  
  URL url = new URL("https://api.tosspayments.com/v1/payments/" + paymentKey);
  
  HttpURLConnection connection = (HttpURLConnection) url.openConnection();
  connection.setRequestProperty("Authorization", authorizations);
  connection.setRequestProperty("Content-Type", "application/json");
  connection.setRequestMethod("POST");
  connection.setDoOutput(true);

  JSONObject obj = new JSONObject();
  obj.put("orderId", orderId);
  obj.put("amount", amount);
  
  OutputStream outputStream = connection.getOutputStream();
  outputStream.write(obj.toString().getBytes("UTF-8"));
  
  int code = connection.getResponseCode();
  boolean isSuccess = code >= 200 && code < 300 ? true : false;
  
  InputStream responseStream = isSuccess? connection.getInputStream(): connection.getErrorStream();
  
  Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);

  JSONParser parser = new JSONParser();
  JSONObject jsonObject = (JSONObject) parser.parse(reader);
  responseStream.close();

%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <title>결제 성공</title>
    <meta charset="UTF8"/>
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>

</head>
<body>
<section>
<% if(isSuccess) { %>
      <h1>결제 성공</h1>
        <h3> 예약신청내역 확인</h3>

	<table>
		
<tr >
			<th>order id</th><th>${Payment.paymentpk}</th>
</tr>
<tr >
			<th>예약날짜</th><th>${Payment.startday}</th>
</tr>
<tr >
			<th>시간</th><th>${Payment.starttime}~${Payment.endtime}</th>
</tr>
<tr >
			<th>금액</th><th>${Payment.totalprice}</th>
</tr>
<tr >
			<th>전공/부전공</th><th>${Payment.majorname}/${Payment.submajorname}</th>
</tr>
<tr >
			<th>Mentor 이름</th><th>${Payment.username}</th>
</tr>
<tr >
			<th><a href="/MentoringProject/menteeBookinglist.do">메인으로</a></th><th><a href="/MentoringProject/menteeBookingList.do">예약리스트 보러가기</a></th>
</tr>
</table>
        <input type="hidden" value="결과 데이터: <%= jsonObject.toJSONString() %>">
    <% } else { %>
    <h1>결제 실패</h1>
    <p>HTTP error code: <%= code %> </p>
    <p><%= jsonObject.get("message") %></p>
    <span>에러코드: <%= jsonObject.get("code") %></span>
<% } %>
</section>

</body>
</html>