<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PW 찾기</title>
</head>
<script type="text/javascript">

function findPw(){
	if(!document.findPwForm.userid.value ){
		alert("ID 를 입력해 주세요");
		return;
		
	}
	if(!document.findPwForm.username.value){
		alert("이름을 입력해 주세요");
		return ;
	}
	
	if(!document.findPwForm.userphone.value){
		alert("번호을 입력해 주세요");
		return ;
	}
	
	findPwForm.submit();
	
}


</script>
<body>
<c:if test="${ findPwResult == 0 }">
	
		<script>
		
			alert("입력하신 정보의 비밀번호가 없습니다. 다시 입력하시거나 회원가입 부탁드립니다.");
			
		</script>
</c:if> 

회원 PW 찾기 페이지 입니다.

		<h2>비밀번호 찾기</h2>
<form action="userFindPwResult.do" method="post" name="findPwForm" >
	<table>
		<tr>
			<td>ID : </td>
			<td>
				<input type="text" name="userid" placeholder="아이디를 입력해주세요">
			</td>
		</tr>
		<tr>
			<td>이름 :</td>
			<td><input type="text" name="username" placeholder="이름을 입력해주세요"></td>
		</tr>	
		<tr>
			<td>핸드폰 : </td>
			<td><input type="tel" name="userphone" placeholder="01011112222"></td>
		</tr>
		<tr>
			<td><input type="button" value="PW 찾기" onClick="findPw(this.form)"></td>
		</tr>
		<tr>
			<td><a href="userLoginPage.jsp">로그인 페이지로 이동</a></td>
		</tr>
	</table>
</form>



</body>
</html>