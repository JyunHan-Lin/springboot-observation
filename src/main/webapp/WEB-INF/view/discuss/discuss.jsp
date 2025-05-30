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
		        	<a href="editDiscuss?id=${discussDTO.discussId}" class="btn btn-danger">編輯</a>
		        	<a href="deleteDiscuss?id=${discussDTO.discussId}" class="btn btn-danger">刪除</a>
		    	  	</div>
		    	</div>
		
			    <!-- 描述 -->
			    <p class="description-text">${discussDTO.description}</p>
		
		    	<!-- YouTube 嵌入影片 -->
		    	<iframe class="video-frame" src="https://www.youtube.com/embed/${discussDTO.youtubeVideoId}"
		    			frameborder="0" allowfullscreen></iframe>
		  
		    	<!-- 留白區 -->
		    	<div class="placeholder-box"></div>
		  	</div>
		
		  	<!-- 右側區域：行為紀錄表單 -->
		  	<div class="right-section">
		    	<h3 class="form-title">行為紀錄</h3>
		
			    <form action="submitBehaviorRecord" method="post">
			      	<label>日期：</label>
		    	  	<input type="date" name="date" />
		
		      		<label>時間：</label>
		      	  	<input type="time" name="startTime" />
		      		<span>~</span>
		      		<input type="time" name="endTime" />
		
		      		<label>對象：</label>
		      		<select name="target">
		        	<option value="">請選擇</option>
		        	
		        	<!-- 選項 -->
		      		</select>
		
		      		<label>行為：</label>
				    <select name="behavior">
				    <option value="">請選擇</option>
				    
		        	<!-- 選項 -->
		      		</select>
		
		      		<label>溫度：</label>
		      		<input type="text" name="temperature" placeholder="℃" />
		
		      		<label>濕度：</label>
		      		<input type="text" name="humidity" placeholder="%" />
		
		      		<label>備註：</label>
		      		<textarea name="note" maxlength="100" placeholder="限100字內"></textarea>
		
		      		<button type="submit" class="btn btn-success">送出</button>
		    	</form>
		  	</div>
		</div>
	</body>
</html>

