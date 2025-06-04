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
		
		<form method="POST" action="/bbd/codeedit">
 			<fieldset class="discussion-form">
 				<legend class="title">會員資料變更</legend>
 				
 				<div class="title">密碼變更</div>
 					<p>
 					<div>
					 	<label for="password">輸入舊密碼：</label>
					 	<input type="password" id="oldpassword" name="password" required><br>
					 	
					 	<label for="password">輸入新密碼：</label>
					 	<input type="password" id="newpassword1" name="password" required><br>
					 	
					 	<label for="password">再輸入一次新密碼：</label>
					 	<input type="password" id="newpassword2" name="password" required><br>
					 	<p>
						<button type="reset" class="button-wrapper">重置</button>
					 	<p>
					 	<button type="submit"class="button-wrapper">確認送出</button>
 					</div>
 			</fieldset>
 		</form>
	</body>
</html>