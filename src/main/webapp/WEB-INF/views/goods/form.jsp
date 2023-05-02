<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
<link href="assets/css/goods.css" rel="stylesheet" type="text/css">
</head>
<body>
<%
// ArrayList<GoodsDTO> GoodsList=(ArrayList<GoodsDTO>)request.getAttribute("GoodsList");
// GoodsDTO dto=new GoodsDTO();
%>
	<h2>GOODS SHOP</h2>
	<div class="container-doc">
		<div class="inner_container">
			<form action="${pageContext.request.contextPath }/goods/goodsWrite" method="get">
				<table>
					<c:forEach var="dto" items="${GoodsList }">
						<tr class="cont_img">
							<td>
								<a href="Goods.kg?G_code=${dto.g_code }"><img src="img/goods/${dto.g_imgS }" width="300px" height="300px"></a><br>
								<span>${dto.g_product }</span><br>
								<span>${dto.g_price }</span>
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