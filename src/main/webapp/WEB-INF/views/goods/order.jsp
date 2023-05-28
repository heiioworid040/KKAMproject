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
	<div class="container-doc">
		<div class="inner_container">
			<form action="${pageContext.request.contextPath }/goods/orderPro" method="post">
				<table>
					<thead>
						<tr>
							<th><input type="checkbox" id="ckAll" onclick="check()"></th>
							<th>이미지</th>
							<th>상품정보</th>
							<th>상품코드</th>
							<th>판매가</th>
							<th>수량</th>
							<th>합계</th>
						</tr>
					</thead>
					<c:forEach var="goods" items="${GoodsList }">
						<tbody>
								<tr>
									<td><input type="checkbox" id="ck"></td>
									<td rowspan='5'>
										<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
									</td>
									<td>${goods.g_product }</td>
									<td>${goods.g_code }</td>
									<td>${goods.g_price }</td>
									<c:if test="${details!=null }">
										<td>${count }</td>
										<td>${goods.g_price*count }원</td>
										<input type="hidden" name="OD_count" value="${count }">
									</c:if>
									<c:if test="${details==null }">
										<td>${goods.b_count }</td>
										<td>${goods.g_price * goods.b_count }</td>
										<input type="hidden" name="OD_count" value="${goods.b_count }">
									</c:if>
								</tr>
						</tbody>
					<input type="hidden" name="G_code" value="${goods.g_code }">
					<input type="hidden" name="OD_price" value="${goods.g_price }">
					</c:forEach>
				</table>
				총 상품 금액 ${price } + 배송비 ${delivery }원 = 합계 금액 ${price+delivery }
				<input type="hidden" name="O_count" value="${count }">
				<input type="hidden" name="O_price" value="${price }">
				<input type="hidden" name="O_delivery" value="${delivery }">
<br><br>
<!-- 			상품 하나거나 0개면 historyback, 여러개면 해당 상품 삭제 -->
				<input type="submit" value="삭제하기">
<br><br>
				주문자 정보
				<table>
					<tr>
						<th>주문하시는 분</th>
						<td>
							<input type="text" name="O_name">
						</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>
							<input type="tel" name="O_phone">
						</td>
					</tr>
<!-- 			<tr> -->
<!-- 				<th>이메일</th> -->
<!-- 				<td> -->
<!-- 					<input type="text" name="O_email"> -->
<!-- 				</td> -->
<!-- 			</tr> -->
				</table>
<br><br>
				택배 정보
				<table>
					<tr>
						<th>받으시는 분</th>
						<td>
							<input type="text" name="D_name">
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type="text" name="D_zipcode">
<br>
							<input type="text" name="D_address"><input type="text" name="D_addressD">
<!-- 					주소 API -->
						</td>
					</tr>
					<tr>
						<th>휴대폰 번호</th>
						<td>
							<input type="tel" name="D_phone">
						</td>
					</tr>
					<tr>
						<th>배송 메시지</th>
						<td>
							<input type="text" name="D_desc">
						</td>
					</tr>
				</table>
<br><br>
				결제 정보
				<table>
					<tr>
						<td>총 주문 금액</td>
						<td>총 할인+적립금 사용 금액</td>
<!-- 				할인/적립금 관련은 수정 예정 -->
						<td>총 결제 예정 금액</td>
					</tr>
					<tr>
						<td>0원</td>
						<td>0원</td>
						<td>0원</td>
					</tr>
				</table>
<br><br>
				결제 수단
				<table>
					<tr>
						<td>
							<input type="radio"> 무통장 입금
						</td>
						<td>
							<input type="radio"> 신용카드
						</td>
					</tr>
				</table>
<br><br>
				최종 결제 금액 0원
<br><br>
				<input type="submit" value="결제하기">
			</form>
		</div>
	</div>
</body>
</html>