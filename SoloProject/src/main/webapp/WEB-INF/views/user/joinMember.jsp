<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>


	<h3>회원가입</h3>
	
	<form action="/user/joinMember" method="post" onsubmit="return formCheck();">
	
		<label>아이디</label><br>
		
		<input type="text" name="id" id="id" placeholder="id"><br>
		<button type="button" onclick="id_check()">중복 확인</button>
		<br>
		
		<label>비밀번호</label><br>
		<input type="password" name="password" id="password1" class="pw" placeholder="password"><br>
		<input type="password" id="password2" class="pw" placeholder="password check"><br>
		<div id="passwordCheck"></div>
		<br>
		<label>이름</label><br>
		<input type="text" name="name" id="name" placeholder="name"><br>
		
		<br>
		<select name="phone1" id="phone1">
			<option value="010">010</option>
			<option value="011">011</option>
			<option value="016">016</option>
		</select> - 
		<input type="text" name="phone2" id="phone2" placeholder="0000"> - 
		<input type="text" name="phone3" id="phone3" placeholder="0000"> 
		
		
		<br><br>
		<input type="submit" value="전송">
		<input type="reset" value="초기화">
		<input type="hidden" name="idCheckVal" id=idCheckVal value="0">
	</form>
    
	<script>

		function id_check(){
						
			$.ajax({
			    type : "POST",
			    url : "/user/idcheck", 
			    data : $('form').serialize(),
			    success : function(num) {

					if(num == 1){
						alert("중복된 ID가 있습니다");
						$('#id').val('');
						
					}else{
						 $('#idCheckVal').val($('#id').val());
						alert("사용가능한 ID 입니다");
					}
			    },
			    error : function(error) {
					alert("실패")
			    }
			});
		}
		

		$('.pw').focusout(function(){
			
			var pwd1 = $('#password1').val();
			var pwd2 = $('#password2').val();
			
			if(pwd1 != pwd2){
				$('#passwordCheck').html('비밀번호가 다릅니다');
				$('#passwordCheck').css('color','red');
			}else{
				$('#passwordCheck').html('비밀번호가 일치합니다');
				$('#passwordCheck').css('color','blue');
			}
		})
		
		$('.ph1').focusout(function(){
			
			var ph1 = $('.ph1').val();
	
			if(ph1.length > 4){
				alert("전화번호 중간 자리는 4자리 이하여야 합니다");
				$('.ph1').val('').focus();
			}
		})
		
		$('.ph2').focusout(function(){
			
			var ph2 = $('.ph2').val();
		
			if(ph2.length > 4){
				alert("전화번호 마지막 자리는 4자리 이하여야 합니다");
				$('.ph2').val('').focus();
			}
		})
	
		function formCheck(){
			
			var id = $('#id').val();
			var pwd1 = $('#password1').val();
			var pwd2 = $('#password2').val();
			var ph1 = $('#phone2').val();
			var ph2 = $('#phone3').val();
			var name = $('#name').val();
				
			if(id == ''){
				alert('id를 입력해주세요');
				$('#id').focus();
				return false;
			}else if($('#idCheckVal').val() != id){
				alert('id 중복 확인을 해주세요');
				return false;
			}else if(pwd1 == ''){
				alert('비밀번호를 입력해주세요');
				$('#password1').focus();
				return false;
			}else if(pwd2 == ''){
				alert('비밀번호를 확인해주세요');
				$('#password2').focus();
				return false;
			}else if(name == ''){
				alert('이름을 입력해 주세요');
				$('#name').focus();
				return false;
			}else if(ph1 == ''){
				alert('휴대폰 번호를 입력해 주세요');
				$('#phone2').focus();
				return false;
			}else if(ph2 == ''){
				alert('휴대폰 번호를 입력해 주세요');
				$('#phone3').focus();
				return false;
			}
		}
		
	</script>
			
</body>
</html>