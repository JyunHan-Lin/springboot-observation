<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Sign up</title>
	</head>
	<body>
		<!-- content -->
		<div>
			<form method="POST" action="/register">
				<fieldset>
					<legend>會員註冊</legend>
					帳號: <input type="text" name="username" placeholder="請輸入帳號" required="required" /><p>
					密碼: <input type="password" name="password" placeholder="請輸入密碼" required="required" /><p>
					電郵: <input type="email" name="email" placeholder="請輸入電子郵件" required="required" /><p>
					<button type="submit">寄送驗證碼</button>
					輸入收到的驗證碼: <input type="text" name="passcode" placeholder="請輸入驗證碼" required="required" /><p>
					人員資格?? 管理員/使用者?<p>
					<button type="reset">清空</button>
					<button type="submit">傳送</button>

				</fieldset>
			</form>
		</div>
	</body>
</html>