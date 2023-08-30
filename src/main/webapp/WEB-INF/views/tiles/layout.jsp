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
    	float: left;
    }
    
    .footer {
		width: 100%;
		height: 50px;            
		text-align: center;
		clear:both;
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
    
</body>
<footer>
	<!--     Page Footer -->
    <tiles:insertAttribute name="footer" />
</footer>
</html>