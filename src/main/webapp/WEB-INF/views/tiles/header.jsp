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
	<div class="header">
		<table>
			<tr>
				<c:choose>
					<c:when test="${id == null }">
						<td><a href="${pageContext.request.contextPath}/user/login">로그인</a></td>
						<td><a href="${pageContext.request.contextPath}/user/join">회원가입</a></td>
					</c:when>
					<c:otherwise>
						<td><a href="${pageContext.request.contextPath}/user/logout">로그아웃</a></td>
					</c:otherwise>
				</c:choose>
						<td>마이페이지</td>
						<td><a href="${pageContext.request.contextPath}/goods/basket">장바구니</a></td>
						<td><a href="${pageContext.request.contextPath}/goods/history">주문조회</a></td>
						<td><a href="${pageContext.request.contextPath}/goods/like">찜목록</a></td>
			</tr>
		</table>
	</div>
</body>
</html>