<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	
</script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="join" method="post">
		<div>
			<h3 class="header">회원가입</h3>
		</div>
		<div class="wrap">
			<div class="row">
				<div class="title">아이디</div>
				<div class="input">
					<input type="text" name="id" id="id" style="width: 120px"
						value="${param.id}" />
				</div>
				<div class="input">
					&nbsp;
					<button name="action" value="duplicate" id="doubldId">중복</button>
				</div>
			</div>

			<c:if test="${not empty isDuplicated}">
			<div class="row">
				<c:choose>
					<c:when test="${isDuplicated}">
						<span class="msg red">이미 존재하는 아이디입니다.</span> &nbsp;
					</c:when>
					<c:otherwise>
						<span class="msg green">사용 가능한 아이디입니다.</span> &nbsp;
					</c:otherwise>
				</c:choose>
			</div>
			</c:if>

			<div class="row">
				<div class="title">이름</div>
				<div class="input">
					<input type="text" name="name"
						value="${param.name}" />
				</div>
			</div>
			<div class="row">
				<div class="title">비밀번호</div>
				<div class="input">
					<input type="text" name="password"
						value="${param.password}" />

				</div>
			</div>
			<div class="row">
				<div class="title">이메일</div>
				<div class="input">
					<input type="text" name="email"
						value="${param.email}" />

				</div>
			</div>
			<div class="row">
				<div class="title">주소</div>
				<div class="input">
					<input type="text" name="address"
						value="${param.address}" />

				</div>
			</div>
			<div>
				<input name="action" type="submit" value="회원가입" />
			</div>
		</div>
	</form>
</body>
</html>