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
		
		<h1>討論串</h1> <button>建立討論串</button>
		<h2>選擇要查看的討論串</h2>
		<form method="POST" action="/bbd/discuss">
 			<fieldset>
				<h3>標題1</h3><h4>內文描述1</h4><button>閱覽</button>
				<h3>標題2</h3><h4>內文描述2</h4><button>閱覽</button>
 			</fieldset>
 		</form>
	</body>
</html>