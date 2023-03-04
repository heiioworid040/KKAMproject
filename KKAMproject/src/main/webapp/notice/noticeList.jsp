<%@page import="com.kkam.notice.db.NoticeDTO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.kkam.notice.db.NoticeDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice/noticeList</title>
</head>
<body>
<%
String id=(String)session.getAttribute("id");
// NoticeDTO dto=new NoticeDTO();

NoticeDAO dao=new NoticeDAO();
ArrayList<NoticeDTO> NoticeList=dao.getNoticeList();
%>
<h1>noticeList</h1>
<form action="NoticeWritePro.no" method="post" enctype="multipart/form-data">

</table>
</form>
</body>
</html>