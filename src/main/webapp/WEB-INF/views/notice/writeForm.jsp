<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice/writeForm.jsp</title>
</head>
<body>
<c:if test = "${empty sessionScope.id }">
	<c:redirect url = "/user/login"></c:redirect>
</c:if>

<h1>글쓰기</h1>
<form action = "${pageContext.request.contextPath}/notice/writePro" method="post">
<table border = "1">
<tr>
	<td>글쓴이</td>
	<td><input type = "text" name = "u_nick" value = "${sessionScope.U_nick }" readonly></td>
</tr>
<tr>
	<td>글제목</td>
	<td><input type = "text" name = "n_title"></td>
</tr>
<tr>
	<td>첨부파일</td>
	<td><input type = "file" name = "n_file"></td>
</tr>
<tr>
	<td>글내용</td>
	<td><textarea name = "n_content" rows = "10" cols = "20"></textarea></td>
</tr>
<tr>
	<td colspan = "2"><input type="submit" value = "글쓰기"></td>
</tr>

</table>
</form>

</body>
</html>