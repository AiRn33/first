<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 조회</title>
</head>
<body>
	<h3>글 조회</h3>
	<br><br>
	<table border="1">
		<tr>
			<td colspan="1">회원 이름</td>
			<td colspan="3">${uvo.name}</td>
		</tr>
		<tr>
			<td colspan="4">${bvo.title}</td>
		</tr>
		<tr>
			<td colspan="4">${bvo.content}</td>
		</tr>
	</table>
	<br>
	<a href="/board/list?userNumber=${bvo.userNumber }">글 리스트로 돌아가기</a>
	<a href="/board/modify?boardNumber=${bvo.boardNumber }">글 수정하기</a>
	<a href="/board/remove?boardNumber=${bvo.boardNumber }">글 삭제하기</a>
	
</body>
</html>