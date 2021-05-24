<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	function check(){
		if(!document.loginform.userid.value){
			alert("ID 를 입력해 주세요");
			return false;
			
		}
		if(!document.loginform.userpw.value){
			alert("Password 입력해 주세요");
			return false;
		}
		if(!document.loginform.userpw2.value){
			alert("Re-Password 입력해 주세요");
			return false;
		}
		
		if(!document.loginform.username.value){
			alert("이름을 입력해 주세요");
			return false;
		}
		if(!document.loginform.useremail.value){
			alert("이메일을 입력해 주세요");
			return false;
		}
		if(!document.loginform.muserphone.value){
			alert("번호을 입력해 주세요");
			return false;
		}
		if(!document.loginform.euserphone.value){
			alert("번호을 입력해 주세요");
			return false;
		}
		if(!checkPassword(loginform.userid.value,loginform.userpw.value , loginform.userpw2.value)){
			alert("비밀번호가 틀립니다.");
			return false;
		}
		return true;
		
	}
	function confirmId(){
		if(document.loginform.userid.value == ""){
			alert("ID 를 입력하세요");
			return;
		}
		
		url = "confirmId.jsp?userid=" + document.loginform.userid.value;
		open(url , "confirm","toolbar=no,location=no,status=no,scrollbar=no,resizable=no,width=300,height=200");
		
	}
	function checkPassword(id,userpw,userpw2){
		var re = /^[a-zA-Z0-9]{4,12}$/;
		if(!password1RegExp.test(userpw)){
			alert("비밀번호는 영문 대소문자와 숫자 4~12 자리로 입력해주셔야 합니다.");
			loginform.userpw.value='';
			loginform.userpw2.value='';
			loginform.userpw.focus();
			return false;
		}
		
		if(userpw != userpw2){
			alert("두 비밀번호가 맞지 않습니다.");
			loginform.userpw.value='';
			loginform.userpw2.value='';
			loginform.userpw.focus();
			return false;
		}
		return true;
	}


</script>
<body>
	
		<form action="userSignUpPage.do" method="post" name="loginform" onsubmit="return check()">
		<table border="0">
			
			<tr>
				<td>ID : </td>
				<td><input type="text" name="userid" placeholder="아이디를 입력해 주세요" autocapitalize="none"></td>
				<td><input type="button" value="ID 중복확인" name="confirm_id" onClick="confirmId(this.form)"/></td>
			</tr>
			
			<tr>
				<td>PW : </td>
				<td> <input type="password" name="userpw" placeholder="비밀번호를 입력해 주세요"></td>
			</tr>
			<tr>
				<td>RE-PW : </td>
				<td> <input type="password" name="userpw2" placeholder="비밀번호를 한번더 입력해 주세요"></td>
			</tr>
			<tr>
				<td> NAME : </td>
			 	<td> <input type="text" name="username" placeholder="이름을 입력해 주세요"> </td>
			</tr>
			<tr>
				<td>EMAIL : </td>
				<td><input type="email" name="useremail"></td>
			</tr>
			<tr>
				<td>PHONE : </td>
				<td><input name="fuserphone" value="010" readonly="readonly" > - <input type="tel" name="muserphone" pattern="[0-9]{4}"> - <input type="tel" name="euserphone" pattern="[0-9]{4}"></td>
			</tr>
			<tr>
				<td><input type="submit" value="가입하기" ></td>
			</tr>
		</table>
		</form>
</body>
</html>