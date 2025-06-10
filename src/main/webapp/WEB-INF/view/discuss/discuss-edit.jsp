<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>🐣 Bird Behavior Document</title>
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" href="/css/form.css">
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>								
		
		<sp:form class="fontstyle" method="post" modelAttribute="discussDTO" action="/bbd/discuss/update/${ discussDTO.discussId }" >
		  <fieldset class="discussion-form">
			<input type="hidden" name="_method" value="PUT" />
		    <legend class="title">編輯討論串</legend>
		    	標題: <sp:input type="text" path="title" placeholder="請輸入標題"/><p />
		    	<p/>
		    	描述: <sp:input type="text" path="description" placeholder="請描述內容" /><p />
		    	<p/>
		    	Youtube連結: <sp:input type="text" path="youtubeVideoId" placeholder="請輸入連結" /><p />
		    	<p/>
		    	<div class="button-wrapper">
					<button type="reset">重置</button>
			    	<button type="submit" class="">建立</button>
		    	</div>
		  </fieldset>
		</sp:form>
	</body>
</html>