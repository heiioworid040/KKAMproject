<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
<link href="${pageContext.request.contextPath }/resources/css/login.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="script/jquery-3.6.3.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$('#login').submit(function(){
		if($('#id').val()==""){
			$('.desc_error').html("아이디를 입력하세요.").css("color","red");
			$('#id').focus();
			return false;
		}
		if($('#pw').val()==""){
			$('.desc_error').html("비밀번호를 입력하세요.").css("color","red");
			$('#pw').focus();
			return false;
		}
	$.ajax({
		url:'LoginCk.kkam',
		data:{'id':$('#id').val(), 'pw':$('#pw').val()},
		success:function(result){
			if(result.trim()=="아이디 혹은 비밀번호가 일치하지 않습니다."){
				$('.desc_error').html(result).css("color","red");
				}
			}
		});
	});
});
</script>
<body>
<div class="container-doc">
	<div class="inner_container">
		<article class="main_article">
			<h1 class="tit_KKAM">
				<span class="logo_KKAM">기깔나는 로고</span>
			</h1>
				<div class="cont_login">
					<form action="${pageContext.request.contextPath }/user/loginPro" id="login" name="id" method="post">
						<div class="box_tf">
							<input type="text" id="id" name="id" placeholder="아이디" class="tf_g">
						</div>
						<div class="box_tf">
							<input type="password" id="pw" name="pw" placeholder="비밀번호" class="tf_g">
						</div>
							<div class="box_desc">
							<p class="desc_error"></p>
							</div>
						
							<button type="submit" class="btn_sub highlight submit">
								로그인
							</button>
					</form>
				</div>
		</article>
	<footer class="footer-doc">
		<a href="${pageContext.request.contextPath }/main" style="text-decoration: none; color: gray;">♡김까미 행복하자♡</a>
	</footer>
	</div>
</div>
</body>
</html>