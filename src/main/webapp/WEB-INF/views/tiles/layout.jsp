<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>KKAM</title>
<style>
/* css파일 따로 빼기 */
    .header {
        background-color: black;
        color: white;
    }
    
    .menu {
    	
    }
    
    .footer {
/*         background-color : ; */
/*         height : 100px; */
    }
</style>
</head>
<body>
    <!-- Page Header -->
    <tiles:insertAttribute name="header" />
    
    <!-- Page Contents -->
    <tiles:insertAttribute name="body" />
    
    <!-- Page Menu -->
    <tiles:insertAttribute name="menu" />
    
<!--     Page Footer -->
<%--     <tiles:insertAttribute name="footer" /> --%>
</body>
</html>