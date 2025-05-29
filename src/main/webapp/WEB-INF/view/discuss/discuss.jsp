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
	<body class="fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>	
		
		<h2>${discuss.title}</h2>
		<p>${discuss.description}</p>

		<!-- YouTube影片嵌入 -->
		<iframe width="640" height="360"
   		 src="https://www.youtube.com/embed/${discuss.youtubeVideoId}"
    	frameborder="0" allowfullscreen>
    	</iframe>

		<!-- 新增行為紀錄表單 -->
		<h3>新增行為紀錄</h3>
		<form action="${pageContext.request.contextPath}/bbd/discuss/${discuss.discussId}" method="post">
    		<input type="hidden" name="discussId" value="${discuss.discussId}" />
    		行為類型：
    		<select name="actionType" required>
        	<option value="VIEW">檢視</option>
       		<option value="EDIT">編輯</option>
        	<option value="COMMENT">評論</option>
        	<!-- 可依需求擴充 -->
   			</select><br/>
    		描述：<input type="text" name="description" /><br/>
    		<button type="submit">新增</button>
		</form>
	</body>
</html>