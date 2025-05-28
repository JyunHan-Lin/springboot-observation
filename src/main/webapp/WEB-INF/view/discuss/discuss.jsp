<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<title>Bird Behavior Document🐣</title>
	</head>
	<body class="container fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>
		
		<h1 class="h1">討論串</h1> <button>建立討論串</button>
		<h2>選擇要查看的討論串</h2>
		<form method="POST" action="/bbd/discuss">
 			<fieldset class="user">
				<h3>標題1</h3><h4>內文描述1</h4><button>閱覽</button>
				<h3>標題2</h3><h4>內文描述2</h4><button>閱覽</button>
 			</fieldset>
 		</form>
	</body>
</html>