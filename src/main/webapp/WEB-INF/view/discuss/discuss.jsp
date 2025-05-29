<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="/css/basic.css">
		<link rel="stylesheet" href="/css/layout.css">
		<link rel="stylesheet" href="/css/discuss.css">
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

		<table>
			<tr>
				<td><a class=" " href="/bbd/discuss/${ discuss.discussId }">編輯</a></td>
				<td>
					<form method="post" action="/bbd/discuss/delete/${ discuss.discussId }">
						<input type="hidden" name="_method" value="DELETE" />
						<button type="submit" class="" >刪除</button>
					</form>						
				</td>
			</tr>
		</table>


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
    		
    		<!-- 行為分析直接呈現在右半邊 -->
		</form>
	</body>
</html>


<%--
<!-- 外層容器 -->
<div class="page-container">

  <!-- 左側區域：標題、影片、留白 -->
  <div class="left-section">

    <!-- 標題與按鈕列 -->
    <div class="header-row">
      <h2 class="title-text">${discuss.title}</h2>
      <div>
        <a href="editDiscuss?id=${discuss.id}" class="btn btn-danger">編輯</a>
        <a href="deleteDiscuss?id=${discuss.id}" class="btn btn-danger">刪除</a>
      </div>
    </div>

    <!-- 描述 -->
    <p class="description-text">${discuss.description}</p>

    <!-- YouTube 嵌入影片 -->
    <iframe class="video-frame" src="https://www.youtube.com/embed/${discuss.youtubeVideoId}"
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

 --%>