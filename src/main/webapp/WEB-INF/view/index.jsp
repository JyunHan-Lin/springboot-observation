<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>BBD</title>
</head>
<body>
 <h1>請登入開始體驗</h1>
 <h2>還沒註冊? 立即<a href="user-register.jsp">註冊</h2>
 
 <form action="login" method="post">
 	<label for="username">帳號：</label>
 	<input type="text" id="username" name="username" required><br>
 	
 	<label for="password">密碼：</label>
 	<input type="password" id="password" name="password" required><br>
 	
 	<label for="authcode">驗證碼：</label>
 	<input type="text" id="authcode" name="authcode" required><br>
 	
 	<input type="submit" value="登入">
 </form>
</body>
</html>