<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPDATE</title>
</head>
<body>
	<h1>UPDATE</h1>
		
		<form action = "${pageContext.request.contextPath }/notice/updatePro" method = "post" enctype = "multipart/form-data">
			<input type = "hidden" name = "num" value = "${noticeDTO.n_num }">
			
				<table border = "1">
					
					
					<tr>
						<td>글쓴이</td>
						<td><input type = "text" name = "id" value = "${noticeDTO.u_id }" readonly></td>
					</tr>
					<tr>
						<td>글제목</td>
						<td><input type = "text" name = "title" value = "${noticeDTO.n_title }"></td>
					</tr>	
					<tr>
						<td>글내용</td>
						<td><textarea name = "text" rows = "10" cols = "20">${noticeDTO.n_text }</textarea></td> 
					</tr>
					<tr>
						<td>첨부파일</td>
						<td><input type = "file" name="img" value = ${noticeDTO.n_img }>
							<input type = "hidden" name = "oldimg" value = "${noticeDTO.n_img }"></td>
					</tr>
					<tr>
						<td colspan = "2"><input type = "submit" value = "글수정"></td>
					</tr>		
						
					
				</table>	
		
		</form>

</body>
</html>