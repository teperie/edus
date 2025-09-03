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
	h2, #paging, #tr_top { text-align: center; }
	table, #member, #paging { margin: auto; width:800px; }
	td, th { border: solid lightgray 1px; }
	td a { text-decoration: none; }
	#member { text-align: right; }
	#tr_top { background: orange }
	#paging a {
		display: inline-block;
		width:20px; height:20px; border:solid gray 1px;
		text-decoration: none;
	}
	#paging .select { background: lightblue; }
	#paging .btn { background: lightgray; }
</style>
</head>
<body>
<h2>글 목록&nbsp;&nbsp;&nbsp;&nbsp;<a href="boardWrite">글쓰기</a></h2>
<div id="member">
	<a href="login">로그인</a>&nbsp;&nbsp;&nbsp;			
	<a href="join">회원가입</a>
</div><br>
<table>
	<tr id="tr_top">
		<th>번호</th><th>제목</th><th>작성자</th><th>날짜</th><th>조회수</th>
	</tr>
	<c:forEach items="${articleList}" var="article">
		<tr>
			<td>${article.num }</td>
			<td><a href="${contextPath}/boardDetail?num=${article.num}">${article.title }</a></td>
			<td>${article.writer }</td>
			<td>${article.createdate }</td>
			<td>${article.viewcnt }</td>
		</tr>
	</c:forEach>

</table>
<br>
<div id="paging">
	<c:choose>
		<c:when test="${pageInfo.curPage>1}">
			<a href="${contextPath}/boardList?page=${pageInfo.curPage-1}">&lt</a>
		</c:when>
		<c:otherwise>
			<a>&lt</a>
		</c:otherwise>
	</c:choose>
	<c:forEach begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1" var="page">
		<a href="${contextPath}/boardList?page=${page}" class="${pageInfo.curPage == page? 'select':'btn' }">${page }</a>
	</c:forEach>
	<c:choose>
		<c:when test="${pageInfo.curPage<pageInfo.allPage}">
			<a href="${contextPath}/boardList?page=${pageInfo.curPage+1}">&gt</a>
		</c:when>
		<c:otherwise>
			<a>&gt</a>
		</c:otherwise>
	</c:choose>
</div>
</body>
</html>