<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp"%>
	<form action="login" method="post">
		<div>
			<h3 class="header">로그인</h3>
		</div>
		<div class="wrap">
			<div class="row">
				<div class="title">아이디</div>
				<div class="input">
					<input type="text" name="id"
						value="${not empty param.id ? param.id : (cookie.id.value != null ? cookie.id.value : '')}" />
				</div>
			</div>
			<div class="row">
				<div class="title">비밀번호</div>
				<div class="input">
					<input type="password" name="password"
						value="${not empty param.password ? param.password : (cookie.password.value != null ? cookie.password.value : '')}" />
				</div>
			</div>
			<div class="row">
				<input type="checkbox" class="title" name="autoLogin" value="true"
					${not empty param.autoLogin or (cookie.autoLogin.value == 'true') ? "checked" : ""} /><b>자동로그인</b>
				<div>
					<input type="submit" value="로그인" /><br>
				</div>
			</div>
		</div>
	</form>
	<c:if test="${not empty isCorrect && !isCorrect}">
		<script>
			alert("아이디 또는 비밀번호가 틀렸습니다.");
		</script>
	</c:if>
</body>
</html>