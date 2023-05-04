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
			<form action="${pageContext.request.contextPath }/goods/goodsWrite" method="get">
				<table>
					<c:forEach var="goods" items="${GoodsList }">
						<tr class="cont_img">
							<td>
								<a href="${pageContext.request.contextPath }/goods/details?G_code=${goods.g_code }"><img src="${pageContext.request.contextPath }/img/goods/${goods.g_imgS }" width="300px" height="300px"></a><br>
								<span>${goods.g_product }</span><br>
								<span>${goods.g_price }</span>
							</td>
						</tr>
					</c:forEach>
				</table>
	
			<button type="submit" class="btn_sub highlight submit">
				글쓰기
			</button>
			</form>
		</div>
	</div>
</body>
</html>