<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>

	<h3>글 수정 폼	</h3>
	
	<form action="/board/modify" method="post">
		<div>
			<label> 제목 </label>
			<input type="text" name="title" value="${vo.title }">
		</div>
		<div>
			<label> 내용 </label>
			<textarea rows="10" cols="50" name="content">${vo.content }</textarea>
		</div>
		<div>
			<input type="hidden" name="boardNumber" value=${vo.boardNumber }>
			<input type="submit" value="전송">
			<input type="reset" value="초기화">
		</div>
	</form>
	
</body>
</html>