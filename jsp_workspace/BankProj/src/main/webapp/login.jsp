<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
</head>
<body>
	<%@ include file="header.jsp" %>
	<form action="login" method="post">
		<div><h3 class="header">로그인</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id" value="${id}"/></div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text" name="password" value="${password}"/></div>
			</div>
			<div>
				<input type="submit" value="로그인"/><br>
			</div>
		</div>
	</form>
</body>
</html>