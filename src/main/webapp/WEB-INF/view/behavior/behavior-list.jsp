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
	<body>
		<!-- menu bar include -->
		<%@ include file="/WEB-INF/view/menu.jspf" %>	
		
		<div class="page-container">
			<fieldset>
				<legend>已建立的行為紀錄</legend>
				<table class="list-order">
					<thead>
						<tr>
							<th>編號</th>
							<th>日期</th>
							<th>開始時間</th>
							<th>結束時間</th>
							<th>對象</th>
							<th>行為</th>
							<th>溫度</th>
							<th>濕度</th>
							<th>備註</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="behaviorDTO" items="${behaviorList}">
							<tr>
								<td>${ behaviorDTO.behaviorId }</td>
								<td>${ behaviorDTO.date }</td>
								<td>${ behaviorDTO.startTime }</td>
								<td>${ behaviorDTO.endTime }</td>
								<td>${ behaviorDTO.subject }</td>
								<td>${ behaviorDTO.action }</td>
								<td>${ behaviorDTO.temperature }</td>
								<td>${ behaviorDTO.humidity }</td>
								<td>${ behaviorDTO.note }</td>
								
								<td><a class="btn btn-danger"
									href="//${ behaviorDTO.behaviorId }">編輯</a></td>
								<td>
									<form method="post" action="//${ behaviorDTO.behaviorId }">
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
