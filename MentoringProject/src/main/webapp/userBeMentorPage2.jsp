<%@page import="com.project.mentoring.dto.AdminSubMajorListDto"%>
<%@page import="com.project.mentoring.dao.AdminSubMajorListDao"%>
<%@page import="com.project.mentoring.dto.AdminMajorListDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.project.mentoring.dao.AdminMajorListDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
			
			AdminMajorListDao adminMajorListDao = new AdminMajorListDao();
			ArrayList<AdminMajorListDto> adminMajorList = adminMajorListDao.majorList();
			
			
			
%>
		
<script type="text/javascript">
	function handleOnChange(e){
		const major = e.value;
		
		document.getElementById("majortext").value = major; 
	}


	function showTable(){
		
		document.getElementById("majorTable").hidden = false;
		
		
	}
	
	function formAction(){
		document.majorIntro.submit()
	}

</script>
<body>

<h1>2단계 : 당신의 전공을 먼저 입력해주세요 ! </h1>
	<form action="mentorProfileMajor.do" method="post">
	<table>
		<tr>
			<td>
				<select name="major" onchange="handleOnChange(this)">
							
						<option value="<%out.print(adminMajorList.get(0).getMajorName()); %>" selected="selected">
									<%out.print(adminMajorList.get(0).getMajorName());%>
						</option>
														
						<%for(int i = 1; i < adminMajorList.size() ; i++){ %>
						<option value="<%out.print(adminMajorList.get(i).getMajorName()); %>">
								<%out.print(adminMajorList.get(i).getMajorName());%>
						</option>
							<%} %>
						
				</select>
			</td>	
		</tr>
		<tr>
			<td>
				<input type="text" id="majortext" name="majorname">
				
			</td>
		</tr>
		<tr>
			<td>
				<input type="submit" value="전공 체크!">
			</td>
		</tr>
	
	</table>
	</form>
	
		
</body>
</html>