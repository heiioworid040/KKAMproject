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
			<form action="${pageContext.request.contextPath }/goods/orderPro" method="post">
				<div class="base-table typeList">
					<table>
						<tr>
							<th>${O_code }</th>
	<%-- 					<th>${O_date }</th> --%>
						</tr>
					</table>
				</div>
				<br>
				<div class="base-table typeList">
					<table>
						<thead>
							<tr>
								<th>이미지</th>
								<th>제품코드</th>
								<th>상품정보</th>
								<th>판매가</th>
								<th>수량</th>
							</tr>
						</thead>
						<c:forEach var="goods" items="${GoodsList }" varStatus="c">
							<tbody>
								<tr>
									<td>
										<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
									</td>
									<td>${goods.g_code }</td>
									<td>${goods.g_product }</td>
									<td>${goods.OD_price }</td>
									<td>${goods.OD_count }</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
				<div class="base-button">
					<button type="submit" id="orderAdd" name="order" value="orderAdd" class="order-btn">재주문하기</button>
				</div>
				<div class="order-area">
					<div class="order-title">
						주문자 정보
					</div>
					<div class="base-table orderList">
						<table>
							<tr>
								<th>주문하시는 분</th>
								<td>
									${order.o_name }
								</td>
							</tr>
							<tr>
								<th>휴대폰 번호</th>
								<td>
									${order.o_phone }
								</td>
							</tr>
			<!-- 		<tr> -->
			<!-- 			<th>이메일</th> -->
			<!-- 			<td> -->
			<!-- 				<input type="text" name="O_email"> -->
			<!-- 			</td> -->
			<!-- 		</tr> -->
						</table>
					</div>
				</div>
				<div class="order-area">
					<div class="order-title">
						택배 정보
					</div>
					<div class="base-table orderList">
						<table>
							<tr>
								<th>받으시는 분</th>
								<td>
									${order.d_name }
								</td>
							</tr>
							<tr>
								<th>주소</th>
								<td>
									${order.d_zipcode }
		<br>
									${order.d_address }
									${order.d_addressD }
								</td>
							</tr>
							<tr>
								<th>휴대폰 번호</th>
								<td>
									${order.d_phone }
								</td>
							</tr>
							<tr>
								<th>배송 메시지</th>
								<td>
									${order.d_desc }
								</td>
							</tr>
						</table>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>