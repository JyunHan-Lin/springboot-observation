<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BBD Login</title>
	</head>
	<body>
		<h1>Bird Behavior Document</h1>
 		<h1>請登入開始體驗</h1>
 		<h2>還沒註冊? 來<a href="/register">註冊</a>吧~</h2>
 		<h3>驗證碼有空再加上去</h3>
 		<form method="POST" action="/login">
 			<fieldset>
			 	<label for="username">帳號：</label>
			 	<input type="text" id="username" name="username" required><br>
			 	
			 	<label for="password">密碼：</label>
			 	<input type="password" id="password" name="password" required><br>
			 	
			 	<label for="authcode">驗證碼：</label>
			 	<input type="text" id="authcode" name="authcode" required><br>
			 	
				<button type="reset" >重置</button>
			 	<button type="submit">登入</button>
 			</fieldset>
 		</form>
	</body>
</html>