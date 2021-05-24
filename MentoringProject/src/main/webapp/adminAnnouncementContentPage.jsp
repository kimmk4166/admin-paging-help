<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<form action="AdminAnnouncementModify.do?noticepk=${adminAnnouncementContentPage.noticepk }" method="post">
			<table border="0">
			<tr>
				<td>제목</td>
				<td><input type="text" name="noticetitle" size="50" value="${adminAnnouncementContentPage.noticetitle }"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea rows="10" cols="50" name="noticetext">${adminAnnouncementContentPage.noticetext }</textarea></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<a href="AdminAnnouncementList.do">목록보기</a>
				&nbsp;&nbsp;&nbsp;<a href="AdminAnnouncementDelete.do?noticepk=${adminAnnouncementContentPage.noticepk }">삭제</a></td>
			</tr>
			</table>
		</form>
</body>
</html>