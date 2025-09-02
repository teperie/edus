<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.header {
	text-align: center;
}

.container {
	margin: 0 auto;
	border: 1px solid;
	width: 600px;
}

.row {
	height: 40px;
	border-top: 1px dotted;
	border-bottom: 1px dotted;
}

.title {
	font-weight: bold;
	background-color: skyblue;
}

.column {
	width: 98px;
	height: 100%;
	float: left;
	line-height: 40px;
	text-align: center;
	border-right: 1px solid;
	border-left: 1px solid;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<form action="">
		<div class="header">
			<h3>전체계좌조회</h3>
		</div>
		<div class="container" id="container">
			<div class="row">
				<div class="title column">순서</div>
				<div class="title column">계좌번호</div>
				<div class="title column">이름</div>
				<div class="title column">입금액</div>
				<div class="title column">종류</div>
				<div class="title column">등급</div>
			</div>
			<c:forEach var="acc" items="${accs}" varStatus="status">
				<div class="row">
					<div class="column">${status.index + 1}</div>
					<div class="column">${acc.id}</div>
					<div class="column">${acc.name}</div>
					<div class="column">${acc.balance}</div>
					<div class="column">
						<c:choose>
							<c:when test="${not empty acc.grade}">특수계좌</c:when>
							<c:otherwise>일반계좌</c:otherwise>
						</c:choose>
					</div>
					<div class="column">
						<c:if test="${not empty acc.grade}">${acc.grade}</c:if>
					</div>
				</div>
			</c:forEach>
		</div>
	</form>
</body>
</html>