<%@page import="com.project.mentoring.dto.AdminSubMajorListDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.mentoring.dao.AdminSubMajorListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>3 단계 : 당신의 세부전공과 당신의 세부 프로필을 작성해주세요! </h2>

<% int majorPk = (int) request.getAttribute("majorPk"); %>
		
		<%
			AdminSubMajorListDao productShowSubMajorListDao = new AdminSubMajorListDao();
			ArrayList<AdminSubMajorListDto> subMajorList= productShowSubMajorListDao.subMajorList(majorPk);
		%>
		
		<% out.println(session.getAttribute("mentorPk")); %>
		
		
	<form action="mentorProfileIntroduce.do" method="post">
		<input type="text" hidden="true" value="<% out.print(session.getAttribute("mentorPk")); %>" name="mentorpk">
		<table id="majorIntro" >
					<tr>
						<td>세부 전공 : </td>
						<td>
							<select name="submajorpk">
							<%for(int i = 1; i < subMajorList.size() ; i++){ %>
								<option value="<%out.print(subMajorList.get(i).getSubmajorPk()); %>" selected="selected"><%out.print(subMajorList.get(i).getSubmajorName()); %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<tr>
					<tr>
						<td>타이틀</td>
						<td>
							<input type="text" placeholder="자신을 나타내는 개성있는 제목!" name="title">
						 </td>
					</tr>
					<tr>
						<td>자기소개 : </td>
						<td><textarea rows="10" cols="50" name="introduce">간단하게 입력하세요</textarea></td>
					</tr>
					<tr>
						<td> 1 시간 가격 : </td>
						<td><input type="text" size = "20" name="price" placeholder="1시간 멘토링 가격을 입력해 주세요!"></td>
					</tr>
					
					<tr>
						<td><input type="submit" value="저장하기"></td>
					</tr>
				</table>
	</form>
	

</body>
</html>