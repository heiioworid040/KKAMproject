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
						<th>총 금액</th>
					</tr>
				</thead>
				<c:forEach var="goods" items="${CartList }">
					<tbody>
						<tr>
							<td>
								<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
							</td>
							<td>${goods.g_product }</td>
							<td>${goods.g_code }</td>
							<td>${goods.g_price }원</td>
							<td>${goods.b_count }</td>
							<td>${goods.g_price * goods.b_count }원</td>
						</tr>
					</tbody>
				</c:forEach>
<!-- 				<tfoot> -->
<!-- 					<tr> -->
<!-- 						<td colspan='5'> -->
<!-- 						원 -->
<!-- 						</td> -->
<!-- 					</tr> -->
<!-- 				</tfoot> -->
			</table>
		</div>
	</div>
</body>
</html>