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
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/script/jquery-3.6.3.js"></script>
<script>
	$(document).ready(function(){
		$('#count').change(function(){
			var price = $('#G_price').val();
			var count = $('#count').val();
			$('#price, #totalP').text(price*count+"원");
			$('#totalC').text("("+count+"개)");
		});
	});
</script>
<script>
	function fun1(index) {
		if(index == 1) {
			document.details.method="get"
			document.details.action="${pageContext.request.contextPath }/goods/order";
		}else if(index == 2) {
			document.details.method="post"
			document.details.action="${pageContext.request.contextPath }/goods/basketPro";
		}else if(index == 3) {
			document.details.method="post"
			document.details.action="${pageContext.request.contextPath }/goods/likePro";
		}else {
			document.details.method="get"
			document.details.action="${pageContext.request.contextPath }/goods/write";
		}
	}
</script>
<body>
	<h2>GOODS SHOP</h2>
	<div id="wrap">
		<div class="contents">
			<form name="details">
				<c:forEach var="goods" items="${GoodsList }">
					<div class="details-thumbnail">
						<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="300px" height="300px"><br>
					</div>
					<div class="details-area">
						<div class="details-product">
							<!-- 관리자일 때만 -->
							<input type="submit" value="수정하기" onclick="fun1(4)">
							<table class="details-table">
								<tr>
									<th colspan="2" style="padding-bottom:7px">
										<span>${goods.g_product }</span>
									</th>
								</tr>
								<tr>
									<th>
										제품코드
									</th>
									<td>
										<span>${goods.g_code }</span>
										<input type="hidden" name="G_code" value="${goods.g_code }">
									</td>
								</tr>
								<tr>
									<th>
										제품가격
									</th>
									<td>
										<span>${goods.g_price }원</span>
										<input type="hidden" id="G_price" name="price" value="${goods.g_price }">
									</td>
								</tr>
								<tr>
									<th>
										제한수량
									</th>
									<td>
										<span>${goods.g_stop }개</span>
									</td>
								</tr>
		<!-- 						<tr> -->
		<!-- 							<td  colspan='2'> -->
		<%-- 								<span>${goods.g_desc }</span> --%>
		<!-- 							</td> -->
		<!-- 						</tr> -->
							</table>
						</div>
						<table class="details-count">
							<tr>
								<td>
									<span>${goods.g_product }</span>
								</td>
								<td>
									<input type="number" id="count" name="count" max="${goods.g_stop }" min="1" value="1">
								</td>
								<td class="right">
									<span id="price">${goods.g_price }원</span>
								</td>
							</tr>
						</table>
						<div class="details-totalPrice">
							<span>총 합계 금액 (수량) : </span>
							<span id="totalP">${goods.g_price }원</span>
							<span id="totalC">(1개)</span>
						</div>
						<div class="details-buyArea">
							<input type="hidden" name="details" value="details">
							<input type="submit" value="구매하기" onclick="fun1(1)" class="details-buyWrap details-order">
							<input type="submit" value="장바구니" onclick="fun1(2)" class="details-buyWrap details-basket">
							<!-- 아래 스크립트로 빼서 중복 코드 삭제하기  -->
							<c:choose>
								<c:when test="${like == null }">
									<input type="submit" value="♡" onclick="fun1(3)" class="details-buyWrap details-like">
								</c:when>
								<c:otherwise>
									<input type="submit" value="♥" onclick="fun1(3)" class="details-buyWrap details-like">
								</c:otherwise>
							</c:choose>
							<!-- 찜 버튼 까미 아이콘으로 수정 예정 -->
						</div>
					</div>
				</c:forEach>
			</form>
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
	</div>
</body>
</html>