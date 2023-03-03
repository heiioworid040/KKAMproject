<%@page import="java.util.ArrayList"%>
<%@page import="com.kkam.goods.db.GoodsDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
</head>
<body>
<%
ArrayList<GoodsDTO> GoodsList=(ArrayList<GoodsDTO>)request.getAttribute("GoodsList");
GoodsDTO dto=new GoodsDTO();
%>
	<h2>GOODS SHOP</h2>
	<div>
		<table>
			<thead>
					<tr>
					</tr>
			</thead>
			<tbody>
				<c:forEach var="dto" items="${GoodsList }">
					<td>
						<img src="img/goods/${dto.g_imgS }" width="300px" height="300px"><br>
						<span>${dto.g_product }</span><br>
						<span>${dto.g_price }</span>
					</td>
				</c:forEach>
			</tbody>
		</table>
	</div>
	
	<form action="GoodsWrite.kg" method="get">
		<button type="submit" class="btn_sub highlight submit">
			글쓰기
		</button>
	</form>
</body>
</html>