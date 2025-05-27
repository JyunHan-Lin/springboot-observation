<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<title>Bird Behavior Document</title>
	</head>
	<body class="fontstyle view2">
		<h1 class="h1">Bird Behavior Document</h1>
 		<form class="login" method="POST" action="/login">
 			<fieldset>
		 		<legend class="h2">登入或<a href="/register">創建帳號</a></legend>
			 	<input type="text" name="username" placeholder="請輸入帳號" required/><p/>
			 	<input type="password" name="password" placeholder="請輸入密碼" required/><p/>
			 
			 	<label for="authcode"></label>
			 	<input type="text" name="authcode" placeholder="請輸入驗證碼" required/><p/>
			 	
				<button type="reset" >重置</button>
			 	<button type="submit">登入</button>
 			</fieldset>
 		</form>
	</body>
</html>