<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
	<script>
	function goPopup(){
		var pop = window.open("/MentoringProject/jusoPopup.jsp","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
	}
	function jusoCallBack(roadFullAddr){
		var addressEI = document.querySelector("#address");
		addressEI.value = roadFullAddr;
	}
	function setThumbnail(event) {
		var reader = new FileReader(); 
		reader.onload = function(event) { 
				var img = document.createElement("img"); 
				img.setAttribute("src", event.target.result); 
				document.querySelector("div#image_container").appendChild(img); 
						}; 
				reader.readAsDataURL(event.target.files[0]); 
				}
	
	function showButton(){
		document.forms["mentorBasicProfile"].submit();
		
	}
		
		
	</script>
<body>

	<h1>1단계 : 개인정보를 입력해 주세요! </h1>
	<form action="mentorProfile.do" method="post" id="mentorBasicProfile" enctype="multipart/form-data">
		<table>
		
			<tr>
				<td>사진 : </td>
				<td><div id="image_container"></div></td>
				<td><input type="file" name="mentorimage" id="image" accept="image/*" onchange="setThumbnail(event);"></td>
			</tr>	
			<tr>
				<td>성별 : </td>
				<td><input type="radio" name="mentorgender" value="1" checked="checked">남
					<input type="radio" name="mentorgender" value="0"> 여 </td>
			</tr>
			<tr>
				<td>생년월일  : </td>
				<td><input type="text" name="year" size="5">년
					<input type="text" name="month" size="5">월
					<input type="text" name="day" size="5">일</td>
			</tr>
			<tr>
					<td>도로명주소</td>
					<td><input type="button" onClick="goPopup();" value="주소 검색"/></td>
					<td><input type="text"  size="50"  name="mentoraddress" id="address" readonly="readonly"></td>
			</tr>
			
			<tr>
				<td> <input id= "insertMentorProfile" type="button" value="기본 정보 등록하기" onclick="showButton()"> </td>
				
			</tr>
			
		</table>
	</form>

		
	
</body>
</html>