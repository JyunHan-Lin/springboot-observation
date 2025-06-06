<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Bird Behavior Document</title>
		<link rel="icon" type="image/png" href="/images/icon.png">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
	</head>
	<body class="view3 fontstyle">
		<!-- body content -->
		<div style="padding: 15px">
			<fieldset class="user">
				${ message }
				<%=exception %><p>
				<a href="/login">回到登入頁</a>
			</fieldset>	
		</div>		
	</body>
</html>