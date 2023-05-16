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
// 		수량 변경 수정 중
		$('#count').change(function(){
			last=$('#ck').length;
			document.basket.action="${pageContext.request.contextPath}/goods/basketPro?G_code=";
			document.basket.submit();
		});
		
		$('#order, #orderAll').click(function(){
		 	document.basket.action="${pageContext.request.contextPath }/goods/order"
		});
	});
	
	function ckAll() {
		if($("input:checked[id='ckAll']").prop("checked")) {
			$("input:[id=ck]").prop("checked", true);
		}else {
			$("input:[id=ck]").prop("checked", false);
		}
	}
	

</script>
<body>
	<h2>GOODS SHOP</h2>
	<div class="container-doc">
		<div class="inner_container">
			<form name="basket" method="get">
				<table>
					<thead>
						<tr>
							<th><input type="checkbox" id="ckAll" onclick="ckAll()"></th>
							<th>이미지</th>
							<th>상품정보</th>
							<th>제품코드</th>
							<th>판매가</th>
							<th>수량</th>
							<th>합계</th>
						</tr>
					</thead>
					<c:forEach var="goods" items="${BasketList }" varStatus="c">
						<tbody>
							<tr>
								<td><input type="checkbox" id="ck"></td>
								<td>
									<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
								</td>
								<td>${goods.g_product }</td>
								<td>${goods.g_code }<input type="hidden" name="G_code" value="${goods.g_code }"></td>
								<td>${goods.g_price }원</td>
								<td><input type="number" id="count${c.index }" name="count" max="${goods.g_stop }" min="1" value="${goods.b_count }"></td>
	<!-- 						수량 조절 수정 예정 -->
								<td>${goods.g_price * goods.b_count }원</td>
							</tr>
						</tbody>
					</c:forEach>
				</table>
				총 상품 금액 ${price } + 배송비 ${delivery }원 = 합계 금액 ${price+delivery }
<br><br>
<!-- 			상품 하나거나 0개면 historyback, 여러개면 해당 상품 삭제 -->
				<input type="submit" value="삭제하기">
				<input type="submit" value="장바구니 비우기">
<br><br>
				<table>
					<tr>
						<td>총 상품 금액</td>
						<td>배송비</td>
	<!-- 				<td>총 할인+적립금 사용 금액</td> -->
	<!-- 				할인/적립금 관련은 수정 예정 -->
						<td>결제 예정 금액</td>
					</tr>
					<tr>
						<td>${price }원</td>
						<td>+${delivery }원</td>
	<!--				<td>0원</td> -->
						<td>=${price+delivery }원</td>
					</tr>
				</table>
<br><br>
				<input type="submit" id="orderAll" value="전체 상품 주문">
				<input type="submit" id="order" value="선택 상품 주문">
			</form>
		</div>
	</div>
</body>
</html>