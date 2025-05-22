<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign up</title>
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/menu.jspf"%>
		<!-- content -->
		<div>
			<form method="POST" action="/register">
				<fieldset>
					<legend>會員註冊</legend>
					帳號: <input type="text" name="username" placeholder="請輸入帳號" required="required" /><p>
					密碼: <input type="text" name="password" placeholder="請輸入密碼" required="required" /><p>
					電郵: <input type="email" name="email" placeholder="請輸入電子郵件" required="required" /><p>
					<button type="reset" class="pure-button">清空</button>
					<button type="submit" class="pure-button pure-button-primary">傳送</button>
				</fieldset>
			</form>
		</div>
	</body>
</html>