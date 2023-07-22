<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
</head>
<body>
	<div class="menu">
<!-- 	임시 메뉴 (위치 / 카테고리 모두 수정 예정) -->
		<a href="${pageContext.request.contextPath}/gallery/form">갤러리</a>
		<br>
		<a href="${pageContext.request.contextPath}/notice/notice">게시판</a>
		<a href="${pageContext.request.contextPath}/goods/form">굿즈샵</a>
		<br>
	</div>
</body>
</html>