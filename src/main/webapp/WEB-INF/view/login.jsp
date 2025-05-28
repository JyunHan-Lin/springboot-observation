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
	<body class="container fontstyle view2">
		<h1 class="h1">Bird Behavior Document</h1>
 		<form class="user" method="POST" action="/login">
 			<fieldset>
		 		<legend class="h2">登入或<a href="/register">創建帳號</a></legend>
			 	<input type="text" name="username" placeholder="請輸入帳號" required/><p/>
			 	<input type="password" name="password" placeholder="請輸入密碼" required/><p/>
			 
			 	<label for="authcode"></label>
				<div class="button-group">
  					<input type="text" name="authCode" placeholder="請輸入驗證碼" required>
  					<img src="/user/authcode" title="驗證碼" alt="驗證碼" />
				</div>
				<div class="button-group">
					<button type="reset" >重置</button>
			 		<button type="submit">登入</button>
				</div>
 			</fieldset>
 		</form>
	</body>
</html>