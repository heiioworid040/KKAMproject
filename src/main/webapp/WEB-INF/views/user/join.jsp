<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>user/join.jsp</title>
</head>
<body>
<h1>회원가입</h1>
<form action = "${pageContext.request.contextPath }/user/joinPro" method="post">
아이디: <input type="text" name="id"><br>
비밀번호: <input type="password" name="pw"><br>
이름: <input type="text" name="name"><br>
닉네임:<input type="text" name="nick"><br>
이메일:<input type="text" name="email">@<input type="text" name="emailD"><br>
생년월일:<input type="text" name="birth"><br>
번호:<input type="text" name="phone"><br>
주소:<input type="text" name="address"><br>
상세주소:<input type="text" name="addressD"><br>
<input type="submit" value="회원가입">
</form>
</body>
</html>