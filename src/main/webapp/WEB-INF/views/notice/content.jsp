<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>       
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CONTENT</title>
</head>
<body>
	<h1>CONTENT</h1>
		<table border = "1">
		
			<tr><td>글번호</td><td>${noticeDTO.n_num }</td></tr>
			<tr><td>작성자</td><td>${noticeDTO.u_id }</td></tr>
			<tr><td>글쓴날짜</td><td>${noticeDTO.n_date }</td></tr>
			<tr><td>조회수</td><td>${noticeDTO.n_view }</td></tr>
			<tr><td>글제목</td><td>${noticeDTO.n_title }</td></tr>
			<tr><td>글내용</td><td>${noticeDTO.n_text }</td></tr>
			<tr><td>첨부파일</td></tr>
			
		</table>
	
</body>
</html>