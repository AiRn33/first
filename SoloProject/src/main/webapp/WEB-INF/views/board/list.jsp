<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<title>글 목록</title>
</head>
<body>

	<h3>list</h3>
	
	<table border="1">
		<tr>
			<th>userNumber</th>
			<th>boardNumber</th>
			<th>title</th>
			<th>content</th>
			<th>createDay</th>
		</tr>
	<c:if test="${empty list}">
		<tr>
			<td colspan="5">글이 존재하지 않습니다</td>
		</tr>
	</c:if>
	<c:if test="${list != null}">
		<c:forEach items="${list }" var="board">
			<tr>
				<td>${board.userNumber }</td>
				<td>${board.boardNumber }</td>
				<td><a href="/board/get?boardNumber=${board.boardNumber }">${board.title }</a></td>
				<td>${board.content }</td>
	            <td><fmt:formatDate pattern="yyyy-MM-dd" value="${board.createDay}"/></td>
			</tr>
		</c:forEach>
	</c:if>
	</table>
	
	<br><br>
	
	<a href="/board/register">새 글 등록하기</a>
	<a href="/user/logout">로그아웃</a>
	
	
</body>
</html>