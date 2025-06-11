<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/common.css">		
		<link rel="stylesheet" href="/css/main.css">
		<title>OrniBase</title>
		<link rel="icon" type="image/png" href="/images/icon.png">
	</head>
	<body class="fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>								
		<!-- 搜尋欄 -->
		<div class="search-container">
	 		<form class="search-form" method="get" action="/bbd/discuss/search">
	    		<input type="text" name="keyword" placeholder="輸入關鍵字搜尋討論串..." class="search-input"/>
	    		<button type="submit" class="search-button">搜尋</button>
			</form>
		</div>
		<!-- 列表 -->
		<%@ include file="/WEB-INF/view/discuss/discuss-list.jspf" %>	
	</body>
</html>