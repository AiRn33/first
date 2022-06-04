<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 생성</title>
</head>
<body>

	<h3>register</h3>
	<form action="/board/register" method="post">
		<div>
			<label>글 제목</label>
			<input type="text" name="title">
		</div>
		<div>
			<label>글 내용</label>
			<textarea rows="10" cols="50" name="content"></textarea>
		</div>
		<input type="hidden" name="userNumber" value=${userNumber }>
		<div>
			<input type="submit" value="전송">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>