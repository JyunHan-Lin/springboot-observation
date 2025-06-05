<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<link rel="stylesheet" href="/css/discuss.css">
		<title>🐣 Bird Behavior Document</title>
		<%@ include file="/WEB-INF/view/charts/googlecharts-head.jspf" %>	
	</head>
	<body class="fontstyle">
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>	
		<!-- 外層容器 -->
		<div class="page-container">
			<!-- 左側區域：標題、影片、留白 -->
			<div class="left-section">
			    <!-- 標題與按鈕列 -->
			    <div class="header-row">
			    	<h2 class="title-text">${discussDTO.title}</h2>
		    	  	<div>
		        		<a href="/bbd/discuss/update/${ discussDTO.discussId }" class="btn btn-danger">編輯</a>
		        		<p>       	
						<form method="post" action="/bbd/discuss/delete/${ discussDTO.discussId }">
							<input type="hidden" name="_method" value="DELETE" />
							<button type="submit" class="btn btn-danger" >刪除</button>
						</form>	
		    	  	</div>
		    	</div>
		
			    <!-- 描述 -->
			    <p class="description-text">${discussDTO.description}</p>
		
		    	<!-- YouTube 嵌入影片 -->
		    	<iframe class="video-frame" src="https://www.youtube.com/embed/${discussDTO.youtubeVideoId}"
		    			frameborder="0" allowfullscreen></iframe>
		  
		    	<!-- 留白區 -->
		    	<a href="/bbd/discuss/stats/${discussDTO.discussId} }">產生圖表</a>
		    	<div class="placeholder-box">
	   				<%@ include file="/WEB-INF/view/charts/googlecharts-body.jspf" %>	
		    	</div>
		  	</div>
		  	<!-- 右側區域：行為紀錄表單 -->
		  	<!-- Behavior -->
			<%@ include file="/WEB-INF/view/behavior/behavior-form.jspf" %>	
		</div>
	</body>
</html>

