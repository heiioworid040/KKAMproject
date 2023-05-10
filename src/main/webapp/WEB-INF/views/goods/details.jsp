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
<script>
	function fun1(index) {
		if(index==1) {
			document.details.action="${pageContext.request.contextPath }/goods/buy";
		}else {
			document.details.action="${pageContext.request.contextPath }/goods/cartPro";
		}
	}
</script>
<body>
	<h2>GOODS SHOP</h2>
	<div class="container-doc">
		<div class="inner_container">
			<form name="details" method="get">
				<table>
					<c:forEach var="goods" items="${GoodsList }">
						<tr>
							<td rowspan='5'>
								<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="300px" height="300px"><br>
							</td>
							<th colspan='2'>
								<span>${goods.g_product }</span><br>
							</th>
						</tr>
						<tr>
							<th>
								제품가격
							</th>
							<td>
								<span>${goods.g_price }</span><br>
							</td>
						</tr>
						<tr>
							<th>
								제품코드
							</th>
							<td>
								<span>${goods.g_code }</span><br>
								<input type="hidden" name="G_code" value="${goods.g_code }">
							</td>
						</tr>
						<tr>
							<th>
								제한수량
							</th>
							<td>
								<span>${goods.g_stop }</span><br>
							</td>
						</tr>
						<tr>
							<td colspan='2'>
								<span>${goods.g_desc }</span><br>
							</td>
						</tr>
						<tr>
							<th>
								<input type="submit" value="구매하기" onclick="fun1(1)">
								<input type="submit" value="장바구니" onclick="fun1(2)">
<!-- 							링크 수정 -->
							</th>
						</tr>
					</c:forEach>
				</table>
			</form>
		</div>
		<table>
			<c:forEach var="goods" items="${GoodsList }">
				<tr>
					<td>
						<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_img }" width="1300px" height="2000px"><br>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>