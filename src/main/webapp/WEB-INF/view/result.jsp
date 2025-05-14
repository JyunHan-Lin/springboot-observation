<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>${resultTitle}</title>
	</head>
	<body>
		<!-- menu bar -->
		<%@ include file="/WEB-INF/view/menu.jsp"  %>
		<!-- content -->
		<div>
			<h1>${resultMessage}</h1>
		</div>
	</body>
</html>