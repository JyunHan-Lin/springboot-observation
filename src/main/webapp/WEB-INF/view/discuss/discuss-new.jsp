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

 		<table>
			<tr>				
				<!-- 列表 -->
				<td valign="top">
					<%@ include file="/WEB-INF/view/discuss/discuss-form.jspf" %>	
				</td>
			</tr>
		</table>
	</body>
</html>