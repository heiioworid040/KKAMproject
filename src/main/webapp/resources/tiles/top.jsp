<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<c:choose>
				<c:when test="${id == null }">
					<td>로그인</td>
					<td>회원가입</td>
				</c:when>
				<c:otherwise>
					<td>로그아웃</td>
				</c:otherwise>
			</c:choose>
					<td>마이페이지</td>
					<td>장바구니</td>
					<td>주문조회</td>
		</tr>
	</table>
</body>
</html>