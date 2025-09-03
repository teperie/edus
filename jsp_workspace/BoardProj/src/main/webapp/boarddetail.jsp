<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath }"/>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	h2,#commandCell { text-align: center; }
	table { margin: auto; width:450px; }
	.td_left { background: orange; width: 150px; }
	.td_right { background: skyblue; width: 300px; }
	#content { height:200px; }
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
<h2>게시판 글 상세</h2>
<table border="1">
	<tr>
		<td class="td_left"><label>글쓴이</label></td>
		<td class="td_right"><span>${article.writer }</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>제목</label></td>
		<td class="td_right"><span>${article.title }</span></td>
	</tr>
	<tr>
		<td class="td_left"><label>내용</label></td>
		<td class="td_right"><div id="content">${article.content }</div></td>
	</tr>
		<tr>
			<td class="td_left"><label>이미지</label></td>
			<td class="td_right">
				<img src="${contextPath}/imageView?filename=${article.imgfilename}" width="100px"/>	
			</td>
		</tr>
		<tr>
			<td class="td_left"><label>파일다운로드</label></td>
			<td class="td_right"><a href="${contextPath}/fileDown?filename=${article.filename}">${article.filename }</a></td>
		</tr>
</table>
<br>
<div id="commandCell">
	<a href="">수정</a>&nbsp;&nbsp;&nbsp;
	<a href="">목록</a>&nbsp;&nbsp;&nbsp;

</div>
</body>
</html>