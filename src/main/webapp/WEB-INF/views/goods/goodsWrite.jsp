<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAMpage</title>
<link href="${pageContext.request.contextPath }/resources/css/goods.css" rel="stylesheet" type="text/css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/script/jquery-3.6.3.js"></script>
    <script type="text/javascript">
        $(function() {
            $("#imgS").on('change', function(){
                readURL(this);
            });
        });

        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();

            reader.onload = function (e) {
                    $('#previewImgS').attr('src', e.target.result);
                }

              reader.readAsDataURL(input.files[0]);
            }
        }
	</script>
<body>
	<h2>GOODS SHOP</h2>
	<div class="inner_container">
		<div class="contents">
<!-- 관리자 계정 아닐 시 화면제어 추가 -->
		<form action="${pageContext.request.contextPath }/goods/goodsWritePro" method="post" enctype="multipart/form-data">
			<table>
				<tr>
					<th>상품코드</th>
					<td><input type="text" name="code"></td>
				</tr>
				<tr>
					<th>구매제한</th>
					<td><input type="text" name="stop"></td>
				</tr>
				<tr>
					<th>상품명</th>
					<td><input type="text" name="product"></td>
				</tr>
				<tr>
					<th>상품가격</th>
					<td><input type="text" name="price"></td>
				</tr>
				<tr>
					<th>상품설명</th>
					<td><input type="text" name="desc"></td>
				</tr>
				<tr>
					<th>상품썸네일</th>
					<td><img id="previewImgS" src="#" width="100px"><br><button type="reset">초기화</button><input type="file" id="imgS" name="imgS"></td>
				</tr>
				<tr>
					<th>상품사진</th>
					<td><img id="previewImg" src="#" width="100px"><br><button type="reset">초기화</button><input type="file" id="img" name="img"></td>
				</tr>
			</table>
			
			<button type="submit" class="btn_sub highlight submit">
				업로드
			</button>
		</form>
		</div>
	</div>
</body>
</html>