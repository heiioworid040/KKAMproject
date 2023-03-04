<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice/noticeForm</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
%>
<h1>noticeForm</h1>
<form action="NoticeWritePro.no" method="post" enctype="multipart/form-data">
<table border="1">
<tr><td>글제목</td>
	<td><input type="text" name="title"></td></tr>
<tr><td>글쓴이</td>
	<td><input type="text" name="nick" value="﻿${sessionScope.id}" readonly></td></tr>	
<tr><td>내용</td>
	<td><textarea name="text" rows="10" cols="10"></textarea></td></tr>
<tr><td>파일첨부</td>
    <td><input type="file" name="img" ></td></tr> 
<tr><td colspan="2"><input type="submit" value="글쓰기"></td></tr>
</table>
</form>
</body>
</html>