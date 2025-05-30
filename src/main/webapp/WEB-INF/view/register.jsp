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
	<body class="fontstyle view3" >
		<form class="user" method="POST" action="/register">
			<fieldset>
				<legend class="h2">會員註冊</legend>
				<input type="text" name="username" placeholder="請輸入帳號" required/><p>
				<input type="password" name="password" placeholder="請輸入密碼" required/><p>
				<input type="email" name="email" placeholder="請輸入電子郵件" required/><p>
				<%--
				<button type="submit">寄送驗證碼</button>
				<input type="text" name="passcode" placeholder="請輸入驗證碼" required/><p>										
				--%>
				<div class="button-group">
					<button type="reset">重置</button>
					<button type="submit">傳送</button>
				</div>
			</fieldset>
		</form>
	</body>
</html>