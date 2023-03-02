<%@page import="com.kkam.user.db.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
	<link href="assets/css/login.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
UserDTO dto=new UserDTO();
String id=(String)request.getAttribute("id");
String pw=(String)request.getAttribute("pw");
%>
<div class="container-doc">
	<div class="inner_container">
		<article class="main_article">
			<h1 class="tit_KKAM">
				<span class="logo_KKAM">기깔나는 로고</span>
			</h1>
				<div class="cont_login">
					<form action="LoginPro.kkam" id="login" name="id" method="post">
						<div class="box_tf">
							<input type="text" name="id" placeholder="아이디" class="tf_g">
						</div>
						<div class="box_tf">
							<input type="password" name="pw" placeholder="비밀번호" class="tf_g">
						</div>
							<button type="submit" class="btn_sub highlight submit">
								로그인
							</button>
					</form>
				</div>
		</article>
	<footer class="footer-doc">
		<span>♡김까미 행복하자♡</span>
	</footer>
	</div>
</div>
</body>
</html>