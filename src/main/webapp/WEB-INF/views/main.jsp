<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
</head>
<body>
	<h2>KKAMpage</h2>
	
		<c:if test="${! empty sessionScope.id}">
			<div id="login">${sessionScope.id } 님 | 
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/user/logout'">로그아웃</button>
			</div>	
		</c:if>
		
		<c:if test="${empty sessionScope.id }">
			<div id="login">
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/user/login'">로그인폼</button> | 
				<button type="button" onclick="location.href='${pageContext.request.contextPath}/user/join'">회원가입폼</button>
				
			</div>
		</c:if>
	
	<br>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/goods/form'">굿즈샵</button>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/goods/cart'">장바구니</button>
	<button type="button" onclick="location.href='${pageContext.request.contextPath}/notice/write'">글쓰기</button>
</body>
</html>