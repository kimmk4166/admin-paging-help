<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="0">
		<form action="AdminAnnouncementWrite.do" method="post">
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticetitle" size="50"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="noticetext"></textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="입력">&nbsp;&nbsp;&nbsp;<a href="AdminAnnouncementList.do">목록보기</a></td>
			</tr>
		</form>
	</table>
</body>
</html>