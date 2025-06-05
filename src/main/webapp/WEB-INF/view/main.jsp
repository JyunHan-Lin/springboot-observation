<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">		
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<title>🐣 Bird Behavior Document</title>
	</head>
	<body class="fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>								
		<!-- 搜尋欄 -->
		<form method="get" action="/bbd/discuss/search">
    		<input type="text" name="keyword" placeholder="輸入關鍵字搜尋..." />
    		<button type="submit">搜尋</button>
		</form>
		<!-- 列表 -->
		<%@ include file="/WEB-INF/view/discuss/discuss-list.jspf" %>	
	</body>
</html>