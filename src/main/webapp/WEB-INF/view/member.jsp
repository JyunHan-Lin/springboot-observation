<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<title>Bird Behavior Document🐣</title>
	</head>
	<body class="container fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<h1 class="h1">變更密碼</h1>
		<form method="POST" action="/bbd/codeedit">
 			<fieldset class="user">
			 	<label for="password">輸入舊密碼：</label>
			 	<input type="password" id="password" name="password" required><br>
			 	
			 	<label for="password">輸入新密碼：</label>
			 	<input type="password" id="password" name="password" required><br>
			 	
			 	<label for="password">再輸入一次新密碼：</label>
			 	<input type="password" id="password" name="password" required><br>
			 	
				<button type="reset" >重置</button>
			 	<button type="submit">確認送出</button>
 			</fieldset>
 		</form>
	</body>
</html>