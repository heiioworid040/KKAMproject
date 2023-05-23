<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>NOTICE</title>
</head>
<body>
	<h1>NOTICE</h1>

		<table border = "1">
			
		
				<tr><td>글번호</td><td>글쓴이</td><td>글제목</td>
								<td>글쓴날짜</td><td>조회수</td></tr>
						
						<c:forEach var = "noticeDTO" items = "${noticeList }">
							
							<tr>
								<td>${noticeDTO.n_num }</td>
								<td>${noticeDTO.u_id }</td>
								<td><a href = "${pageContext.request.contextPath}/notice/content?N_num = ${noticeDTO.n_num }"></a>
									${noticeDTO.n_title }</td>
								<td>${noticeDTO.n_date }</td>
								<td>${noticeDTO.n_view }</td>
							</tr>
						
						</c:forEach>
	
		</table>

		<c:if test="${pageDTO.startPage > pageDTO.pageBlock }">
				<a href="${pageContext.request.contextPath}/notice/notice?pageNum=${pageDTO.startPage - pageDTO.pageBlock}">◀</a>
		</c:if>

			<c:forEach var="i" begin="${pageDTO.startPage }" end="${pageDTO.endPage }" step="1">
				<a href="${pageContext.request.contextPath}/notice/notice?pageNum=${i}">${i}</a>
			</c:forEach>

		<c:if test="${pageDTO.endPage < pageDTO.pageCount }">
			<a href="${pageContext.request.contextPath}/notice/notice?pageNum=${pageDTO.startPage + pageDTO.pageBlock}">▶</a>
		</c:if>
	
</body>
</html>