<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Spring Form 表單標籤 -->
<%@ taglib prefix="sp" uri="http://www.springframework.org/tags/form" %>
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
		
		<div>
			<fieldset  class="behavior-form">
				<legend class="title">已建立的行為紀錄</legend>
				<table>
					<thead>
						<tr>
							<th>行為日期</th>
							<th>開始時間</th>
							<th>結束時間</th>
							<th>對象</th>
							<th>行為</th>
							<th>溫度</th>
							<th>濕度</th>
							<th>備註</th>
							<th>記錄日期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="behaviorDTO" items="${behaviorList}">
							<tr>
								<td>${ behaviorDTO.date }</td>
								<td>${ behaviorDTO.startTime }</td>
								<td>${ behaviorDTO.endTime }</td>
								<td>${ behaviorDTO.subject }</td>
								<td>${ behaviorDTO.action }</td>
								<td>${ behaviorDTO.temperature }</td>
								<td>${ behaviorDTO.humidity }</td>
								<td>${ behaviorDTO.note }</td>
								<td>${ behaviorDTO.createdTime }</td>
								
								<td>
								<a href="/bbd/discuss/behavior/${ behaviorDTO.discussId }/edit/${ behaviorDTO.behaviorId }" class="btn btn-danger">編輯</a>
								</td>
								<td>
									<form method="post" action="/bbd/discuss/behavior/${ behaviorDTO.discussId }/delete/${ behaviorDTO.behaviorId }">
										<input type="hidden" name="_method" value="DELETE" />
										<button type="submit" class="btn btn-danger">刪除</button>
									</form>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</fieldset>
		</div>
	</body>
</html>
