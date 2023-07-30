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
			<form name="like">
				<div class="base-table typeList">
					<table>
						<colgroup>
							<col style="width: 3%" />
							<col span="4" style="width: 14%" />
						</colgroup>
						<thead>
							<tr>
								<th><input type="checkbox" id="ckAll" onclick="check()"></th>
								<th>이미지</th>
								<th>상품정보</th>
								<th>제품코드</th>
								<th>판매가</th>
							</tr>
						</thead>
						<c:forEach var="goods" items="${LikeList }">
							<tbody>
								<tr>
									<td><input type="checkbox" id="ck" name="ck" value="${goods.g_code }"></td>
									<td>
										<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
									</td>
									<td><a href="${pageContext.request.contextPath }/goods/details?G_code=${goods.g_code }">${goods.g_product }</a></td>
									<td>${goods.g_code }<input type="hidden" name="G_code" value="${good.g_code }"></td>
									<td>${goods.g_price }원</td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
				</div>
<!-- 			상품 하나거나 0개면 historyback, 여러개면 해당 상품 삭제 -->
				<div class="base-button">
					<button type="submit" id="likeDel" name="like" value="likeDel" class="order-btn">삭제하기</button>
					<button type="submit" id="likeMove" name="like" value="likeMove" class="order-btn">장바구니 담기</button>
				</div>
<br><br>
				<div class="details-buyArea">
					<button type="submit" id="orderAll" name="like" value="orderAll" class="details-buyWrap order-orderAll">전체 상품 주문</button>
					<button type="submit" id="order" name="like" value="order" class="details-buyWrap order-order">선택 상품 주문</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>