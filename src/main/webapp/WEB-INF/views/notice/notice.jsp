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
							
							<tr><td>${noticeDTO.N_num }</td>
								<td>${noticeDTO.U_id }</td>
								<td><a href = "${pageContext.request.contextPath}/notice/content?N_num = ${noticeDTO.N_num }"></a>
									${noticeDTO.N_title }</td>
								<td>${noticeDTO.N_date }</td>
								<td>${noticeDTO.N_view }</td>
							</tr>
						
						</c:forEach>
	
		</table>
	
</body>
</html>