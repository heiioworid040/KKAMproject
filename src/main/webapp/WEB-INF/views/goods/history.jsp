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
	<div id="wrap">
		<div class="contents">
			<div class="base-table typeList">
				<table>
					<thead>
						<tr>
							<th>주문번호</th>
							<th>주문날짜</th>
							<th>금액</th>
						</tr>
					</thead>
					<c:forEach var="goods" items="${GoodsList }" varStatus="c">
						<tbody>
							<tr>
								<td><a href="${pageContext.request.contextPath }/goods/histroyDetails?O_code=${goods.o_code }">${goods.o_code }</a></td>
								<td>${goods.o_date }<input type="hidden" name="O_code" value="${good.o_code }"></td>
								<td>${goods.o_price + goods.o_delivery }원</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>