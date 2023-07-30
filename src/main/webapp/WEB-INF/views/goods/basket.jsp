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
		function updateCount(G_code, count, basket){
			$.post("${pageContext.request.contextPath}/goods/basketPro", { G_code: G_code, count: count, basket: basket }, function() {
				document.basket.submit();
			});
		};
		
	$(document).ready(function(){
		$('#order, #orderAll').click(function(){
			document.basket.method="get"
		 	document.basket.action="${pageContext.request.contextPath }/goods/order";
		});

		$('#basketDel, #basketAllDel').click(function(){
			document.basket.method="post"
		 	document.basket.action="${pageContext.request.contextPath }/goods/basketPro";
		});
	});
</script>
<script>
	function check() {
		if($("input:checked[id='ckAll']").prop("checked")) {
			$("input[id=ck]").prop("checked", true); 
		}else {
			$("input[id=ck]").prop("checked", false); 
		}
	}
</script>
<body>
	<h2>GOODS SHOP</h2>
	<div id="wrap">
		<div class="contents">
			<form name="basket">
				<div class="base-table typeList">
					<table>
						<colgroup>
							<col style="width: 3%" />
							<col span="6" style="width: 14%" />
						</colgroup>
						<thead>
							<tr>
								<th><input type="checkbox" id="ckAll" onclick="check()"></th>
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
									<td><input type="checkbox" id="ck" name="ck" value="${goods.g_code }"></td>
									<td>
										<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
									</td>
									<td><a href="${pageContext.request.contextPath }/goods/details?G_code=${goods.g_code }">${goods.g_product }</a></td>
									<td>${goods.g_code }<input type="hidden" name="G_code" value="${good.g_code }"></td>
									<td>${goods.g_price }원</td>
									<td><input type="number" id="count${c.index }" name="count" max="${goods.g_stop }" min="1" value="${goods.b_count }" onchange="updateCount('${goods.g_code }', this.value, 'basketUp')"></td>
		<!-- 						수량 조절 수정 예정 -->
									<td>${goods.g_price * goods.b_count }원</td>
								</tr>
							</tbody>
						</c:forEach>
						<tfoot>
							<tr>
								<td colspan="7">
									총 상품 금액 ${price } + 배송비 ${delivery }원 = 합계 금액 ${price+delivery }
								</td>
							</tr>
						</tfoot>
					</table>
				</div>
<!-- 			상품 하나거나 0개면 historyback, 여러개면 해당 상품 삭제 -->
				<div class="base-button">
					<button type="submit" id="basketDel" name="basket" value="basketDel" class="order-btn">삭제하기</button>
					<button type="submit" id="basketAllDel" name="basket" value="basketAllDel" class="order-btn">비우기</button>
				</div>
				<div class="base-table typeList">
					<table>
						<tr>
							<th>총 상품 금액</th>
							<th>배송비</th>
<!-- 						<th>총 할인+적립금 사용 금액</th> -->
<!-- 						할인/적립금 관련은 수정 예정 -->
							<th>결제 예정 금액</th>
						</tr>
						<tr>
							<td>${price }원</td>
							<td>+${delivery }원</td>
	<!--					<td>0원</td> -->
							<td>=${price+delivery }원</td>
						</tr>
					</table>
				</div>
<br><br>
				<div class="details-buyArea">
					<button type="submit" id="orderAll" name="basket" value="orderAll" class="details-buyWrap order-orderAll">전체 상품 주문</button>
					<button type="submit" id="order" name="basket" value="order" class="details-buyWrap order-order">선택 상품 주문</button>
				</div>
			</form>
		</div>
	</div>
</body>
</html>