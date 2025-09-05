<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h2, #paging, #tr_top {
	text-align: center;
}

table, #member, #paging {
	margin: auto;
	width: 800px;
}

td, th {
	border: solid lightgray 1px;
}

td a {
	text-decoration: none;
}

#member {
	text-align: right;
}

#tr_top {
	background: orange
}

#paging a {
	display: inline-block;
	width: 20px;
	height: 20px;
	border: solid gray 1px;
	text-decoration: none;
}

#paging .select {
	background: lightblue;
}

#paging .btn {
	background: lightgray;
}
</style>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$(".delBtn").click(function() {
			const num = $(this).data("num");
			if (confirm("정말 삭제하시겠습니까?")) {
				$.ajax({
					url : `${contextPath}/boardDelete`,
					type : 'post',
					async : true,
					dataType : 'text',
					data : {
						num : num
					},
					success : function(result) {
						if (result == 'true') {
							alert("삭제되었습니다.");
							location.href = `${contextPath}/boardList`;
						} else if (result == 'false') {
							alert("삭제 실패");
						}
					},
					error : function() {
						alert("에러 발생");
					}
				});
			} else {
				return;
			}
		});
	})
</script>
</head>
<body>
	<h2>
		글 목록&nbsp;&nbsp;&nbsp;&nbsp;<a href="boardWrite">글쓰기</a>
	</h2>
	<div id="member">
		<c:choose>
			<c:when test="${user != null }">
            (${user.name }님 환영합니다.)
            <a href="logout">로그아웃</a>
			</c:when>
			<c:otherwise>
				<a href="login">로그인</a>&nbsp;&nbsp;&nbsp; <a href="join">회원가입</a>
			</c:otherwise>
		</c:choose>
	</div>

	<br>
	<table>
		<tr id="tr_top">
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach items="${articleList}" var="article">
			<tr>
				<td>${article.num }</td>
				<td><a href="${contextPath}/boardDetail?num=${article.num}">${article.title }</a></td>
				<td>${article.writer }</td>
				<td>${article.createdate }</td>
				<td>${article.viewcnt }</td>
				<td><button
						${user==null || user.id!=article.writer? 'disabled':'' }
						class="delBtn" data-num="${article.num}">삭제</button></td>
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
		<c:forEach begin="${pageInfo.startPage }" end="${pageInfo.endPage }"
			step="1" var="page">
			<a href="${contextPath}/boardList?page=${page}"
				class="${pageInfo.curPage == page? 'select':'btn' }">${page }</a>
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