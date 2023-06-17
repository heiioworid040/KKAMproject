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
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
	function zip() {
	    new daum.Postcode({
	        oncomplete: function(data) {
                var addr = '';
                if (data.userSelectedType === 'R') {
                    addr = data.roadAddress;
                } else {
                    addr = data.jibunAddress;
                }
                document.getElementById('D_zipcode').value = data.zonecode;
                document.getElementById("D_address").value = addr;
                document.getElementById("D_addressD").focus();
	        }
	    }).open();
	}
</script>
<body>
	<h2>GOODS SHOP</h2>
	<div id="wrap">
		<div class="inner_container">
			<div class="contents">
				<form action="${pageContext.request.contextPath }/goods/orderPro" method="post">
					<div class="base-table typeList">
						<table>
							<colgroup>
								<col span="7" style="width: 14%" />
							</colgroup>
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
											<td><input type="checkbox" id="ck" name="ck" value="${goods.g_code }"></td>
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
							<tfoot>
								<tr>
									<td colspan="7">
										총 상품 금액 ${price } + 배송비 ${delivery }원 = 합계 금액 ${price+delivery }
									</td>
								</tr>
							</tfoot>
						</table>
					</div>
					<input type="hidden" name="O_count" value="${count }">
					<input type="hidden" name="O_price" value="${price }">
					<input type="hidden" name="O_delivery" value="${delivery }">

		<!-- 		상품 하나거나 0개면 historyback, 여러개면 해당 상품 삭제 -->
					<div class="base-button">
						<button type="submit" id="orderDel" name="order" value="orderDel" class="order-btn">삭제하기</button>
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
										<input type="text" name="O_name">
									</td>
								</tr>
								<tr>
									<th>휴대폰 번호</th>
									<td>
										<input type="tel" name="O_phone1">
										<span class="order-tel">-</span>
										<input type="tel" name="O_phone2">
										<span class="order-tel">-</span>
										<input type="tel" name="O_phone3">
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
										<input type="text" name="D_name">
									</td>
								</tr>
								<tr>
									<th>주소</th>
									<td>
										<input type="text" id="D_zipcode" name="D_zipcode"><button type="button" onclick="zip()">우편번호 찾기</button>
			<br>
										<input type="text" id="D_address" name="D_address"><input type="text" id="D_addressD" name="D_addressD">
			<!-- 					주소 API -->
									</td>
								</tr>
								<tr>
									<th>휴대폰 번호</th>
									<td>
										<input type="tel" name="D_phone1">
										<span class="order-tel">-</span>
										<input type="tel" name="D_phone2">
										<span class="order-tel">-</span>
										<input type="tel" name="D_phone3">
									</td>
								</tr>
								<tr>
									<th>배송 메시지</th>
									<td>
										<input type="text" name="D_desc">
									</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="order-area">
						<div class="order-title">
							결제 정보
						</div>
						<div class="base-table typeList">
							<table>
								<tr>
									<th>총 주문 금액</th>
									<th>총 할인+적립금 사용 금액</th>
			<!-- 				할인/적립금 관련은 수정 예정 -->
									<th>총 결제 예정 금액</th>
								</tr>
								<tr>
									<td>${price+delivery }원</td>
									<td>0원</td>
									<td>${price+delivery }원</td>
								</tr>
							</table>
						</div>
					</div>
					<div class="order-area">
						<div class="order-title">
							결제 수단
						</div>
						<div class="order-area-pay">
							<div class="order-radio">
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
							</div>
							<div class="order-area-pay2">
								<div class="order-submit">
									최종 결제 금액 ${price+delivery }원
									<input type="submit" value="결제하기" class="order-buyWrap order-orderAll">
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>