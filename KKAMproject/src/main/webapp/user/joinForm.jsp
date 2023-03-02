<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Join</h1>
<form action="JoinPro.kkam" method="post">
이름: <input type="text" name="name"><br>
아이디: <input type="text" name="id"><br>
비밀번호: <input type="password" name="pw"><br>
닉네임: <input type="text" name="nick"><br>
생년월일: <input type="text" name="birth"><br>
휴대폰 번호: <input type="tel" name="phone"><br>
이메일: <input type="text" name="email"> @ <input type="text" name="emailD"> 셀렉트로 변경할거임 <br>
주소: <input type="text" name="address"> api 적용!<br>
상세주소: <input type="text" name="address2"><br>
<input type="submit" value="회원가입">

</form>
</body>
</html>