<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>

	<h3>login</h3>
	<c:if test="${check == false }">
		<script>
	      alert('로그인에 실패하였습니다');
	    </script>
	</c:if>
		
	<form action="/user/login" method="post">
	
		<label>아이디</label><br>
		<input type="text" name="id"><br>
	
		<br>
		<label>비밀번호</label><br>
		<input type="password" name="password"><br>
	
		<br>
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
	</form>
	
	<br><br>
	
	<div>
		<a href="/user/joinMember">회원가입</a>
		<a href="/user/memberCheck">아이디 비밀번호 찾기</a>
	</div>
	
	<script type="text/javascript">
		history.pushState(null, null, location.href);
	
		window.onpopstate = function(event) {
			history.go(1);
		};
	</script>
	
</body>
</html>