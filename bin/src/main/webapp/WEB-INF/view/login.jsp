<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>BBD Login</title>
	</head>
	<body>
 		<h1>請登入開始體驗</h1>
 		<h2>還沒註冊? 來<a href="/bbd/register">註冊</a>吧~</h2>
 
 		<form method="POST" action="/bbd">
 			<fieldset>
			 	<label for="username">帳號：</label>
			 	<input type="text" id="username" name="username" required><br>
			 	
			 	<label for="password">密碼：</label>
			 	<input type="password" id="password" name="password" required><br>
			 	
			 	<img src="${pageContext.request.contextPath}/user/authcode" alt="驗證碼圖片" />
				<input type="text" name="authcode" placeholder="請輸入驗證碼" />
			 	
				<button type="reset" >重置</button>
			 	<button type="submit">登入</button>
 			</fieldset>
 		</form>
	</body>
</html>