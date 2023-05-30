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
			<tr><td>글내용</td><td><img src="${pageContext.request.contextPath}/resources/upload/${noticeDTO.n_img }" width="100" height="100"><br>
											${noticeDTO.n_text }</td></tr>
			<tr><td colspan="2">	
		
					<c:if test="${ ! empty sessionScope.id }">
						<c:if test="${sessionScope.id eq noticeDTO.u_id }">
						 	<input type="button" value="글수정"
 									onclick="location.href='${pageContext.request.contextPath}/notice/update?N_num=${noticeDTO.n_num}'">
							<input type="button" value="글삭제"
 									onclick="location.href='${pageContext.request.contextPath}/notice/delete?N_num=${noticeDTO.n_num}'">				
						</c:if>
					</c:if>	
				
							<input type="button" value="글목록"
							  onclick="location.href='${pageContext.request.contextPath}/notice/notice'">
				</td></tr>				
								  
		</table>
		
<!-- 		댓글 시작 -->
				<c:forEach var = "commentDTO" items = "${commentList }">
					${commentDTO.u_id }<br>
					${commnetDTO.c_date }<br>
					${commentDTO.c_cont }<br>					
				</c:forEach>
				
	
	<form  action="/notice/commentPro" method = "post">
		<textarea name="cont" rows="5" cols="10"></textarea>
		<input type="submit" value="댓글쓰기">

		<input type="hidden" name="num" value="${noticeDTO.n_num }">
		<input type="hidden" name="id" value="${sessionScope.id }">
	</form>
		
		
		
	
</body>
</html>