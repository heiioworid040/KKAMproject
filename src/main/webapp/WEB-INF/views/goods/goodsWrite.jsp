<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
</head>
<body>
<!-- 관리자 계정 아닐 시 화면제어 추가 -->
	<form action="${pageContext.request.contextPath }/goods/goodsWritePro" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<th>상품코드</th>
				<td><input type="text" name="code"></td>
			</tr>
			<tr>
				<th>구매제한</th>
				<td><input type="text" name="stop"></td>
			</tr>
			<tr>
				<th>상품명</th>
				<td><input type="text" name="product"></td>
			</tr>
			<tr>
				<th>상품가격</th>
				<td><input type="text" name="price"></td>
			</tr>
			<tr>
				<th>상품설명</th>
				<td><input type="text" name="desc"></td>
			</tr>
			<tr>
				<th>상품썸네일</th>
				<td><input type="file" name="imgS"></td>
			</tr>
			<tr>
				<th>상품사진</th>
				<td><input type="file" name="img"></td>
			</tr>
		</table>
		
		<button type="submit" class="btn_sub highlight submit">
			업로드
		</button>
	</form>
</body>
</html>