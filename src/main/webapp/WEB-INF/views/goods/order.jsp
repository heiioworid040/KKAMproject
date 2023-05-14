<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
<link href="${pageContext.request.contextPath }/resources/css/goods.css" rel="stylesheet" type="text/css">
</head>
<body>
	<h2>GOODS SHOP</h2>
	<div class="container-doc">
		<div class="inner_container">
			<table>
				<thead>
					<tr>
						<th>제품사진</th>
						<th>제품명</th>
						<th>제품코드</th>
						<th>가격</th>
						<th>개수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="goods" items="${GoodsList }">
						<tr>
							<td rowspan='5'>
								<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
							</td>
							<td>${goods.g_product }</td>
							<td>${goods.g_code }</td>
							<td>${goods.g_price }</td>
							<td>${OD_count }</td> 
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>