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
			<table>
				<thead>
					<tr>
						<th><input type="checkbox" id="ckAll" onclick="ckAll()"></th>
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
								<td>
									<input type="checkbox" id="ck">
								</td>
								<td rowspan='5'>
									<img src="${pageContext.request.contextPath }/resources/upload/${goods.g_imgS }" width="100px" height="100px"><br>
								</td>
								<td>${goods.g_product }</td>
								<td>${goods.g_code }</td>
								<td>${goods.g_price }</td>
								<td>${OD_count }</td> 
								<td>${goods.g_price*OD_count }원</td>
							</tr>
					</tbody>
					<tfoot>
						<tr>
							<td>
								상품구매금액 ${goods.g_price*OD_count }
							</td>
							<td>
								+
							</td>
							<td>
								<c:choose>
									<c:when test="${goods.g_price*OD_count>100000 }">
										배송비 0 (무료)
										<input type="hidden" name="O_delivery" value="무료">
									</c:when>
									<c:otherwise>
										배송비 2500
										<input type="hidden" name="O_delivery" value="2500">
									</c:otherwise>
								</c:choose>
							</td>
							<td>
								=
							</td>
							<td>
								<c:choose>
									<c:when test="${goods.g_price*OD_count>100000 }">
										합계 : ${goods.g_price*OD_count }원
										<input type="hidden" name="O_price" value="${goods.g_price*OD_count }">
									</c:when>
									<c:otherwise>
										합계 : ${goods.g_price*OD_count+2500 }원
										<input type="hidden" name="O_price" value="${goods.g_price*OD_count+2500 }">
									</c:otherwise>
								</c:choose>
							</td>
						</tr>
					</tfoot>
				</c:forEach>
			</table>
<!-- 			상품 하나면 historyback, 여러개면 해당 상품 삭제 -->
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
						<input type="text" name="D_address" readonly><input type="text" name="D_addressD">
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
		</div>
	</div>
</body>
</html>