<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/common.css">
		<link rel="stylesheet" href="/css/behavior-edit.css">
		<title>Bird Behavior Document</title>
		<link rel="icon" type="image/png" href="/images/icon.png">
	</head>
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>								
		
		<sp:form class="fontstyle" method="post" modelAttribute="behaviorDTO" action="/bbd/discuss/behavior/${ behaviorDTO.discussId }/edit/${ behaviorDTO.behaviorId }" >
		  <fieldset class="discussion-form">
			<input type="hidden" name="_method" value="PUT" />
		    <legend class="title">編輯行為</legend>
		    	<label>日期：</label>
	    	  	<input type="date" name="date" />
	
				<!-- 加上這個容器 -->
				<div class="time-row">
				  <label for="startTime">時間：</label>
				  <input type="time" name="startTime" id="startTime" />
				  <span>～</span>
				  <input type="time" name="endTime" id="endTime" />
				</div>

	      		<label>對象：</label>
	      		<select name="subject">
	        	<option value="">請選擇</option>
	        	<option value="成鳥A">成鳥A</option>
 					<option value="成鳥B">成鳥B</option>
 					<option value="幼鳥A">幼鳥A</option>
	      		</select>
	
	      		<label>行為：</label>
			    <select name="action">
			    <option value="">請選擇</option>
	        	<option value="飛行">飛行</option>
 					<option value="進食">進食</option>
 					<option value="其他">其他</option>
	      		</select>

				<!-- 溫度與濕度欄位在同一行 -->
				<div class="form-row">
				  <div class="form-group">
				    <label>溫度：</label>
				    <input type="text" name="temperature" placeholder="℃" />
				  </div>
				  <div class="form-group">
				    <label>濕度：</label>
				    <input type="text" name="humidity" placeholder="%" />
				  </div>
				</div>

	      		<label>備註：</label>
	      		<textarea name="note" maxlength="100" placeholder="限100字內"></textarea>
	
				<button type="submit" class="btn btn-success">送出</button>	
		  </fieldset>
		</sp:form>
	</body>
</html>