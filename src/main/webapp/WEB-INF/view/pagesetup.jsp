<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bird Behavior Document</title>
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<h1>個人化設定網頁</h1>
		<!-- content -->
		<div>
			<form method="POST" action="/bbd/pageeedit">
				<fieldset>
					<legend>畫面個人化設定</legend>
					顏色: <input type="checkbox" name="color"/>
					<button type="submit" class="pure-button pure-button-primary">變更</button>
				</fieldset>
			</form>
		</div>
	</body>
</html>