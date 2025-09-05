<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
	$(function() {
		$("#doubldId").click(function(e) {
			e.preventDefault();
			const id = $("#id").val();
			if (id == "") {
				alert("아이디를 입력하세요");
				$("#id").focus();
				return;
			}
			$.ajax({
				url : `${contextPath}/idcheck`,
				type : 'post',
				async : true,
				dataType : 'text',
				data : {
					id : $("#id").val()
				},
				success : function(result) {
					if (result == true) {
						alert("아이디가 중복되었습니다.");
					} else if (result == false) {
						alert("사용 가능한 아이디입니다.");
					}
				},
				error : function() {
					alert("에러 발생");
				}
			});
		});
	})
</script>

</head>
<body>
	<form action="${contextPath}/join" method="post">
		<div>
			<h3 class="header">회원가입</h3>
		</div>
		<div class="wrap">
			<div class="row">
				<div class="title">아이디</div>
				<div class="input">
					<input type="text" name="id" id="id" style="width: 120px" />
				</div>
				<div class="input">
					&nbsp;
					<button id="doubldId">중복</button>
				</div>
			</div>
			<div class="row">
				<div class="title">이름</div>
				<div class="input">
					<input type="text" name="name" />
				</div>
			</div>
			<div class="row">
				<div class="title">비밀번호</div>
				<div class="input">
					<input type="text" name="password" />
				</div>
			</div>
			<div class="row">
				<div class="title">이메일</div>
				<div class="input">
					<input type="text" name="email" />
				</div>
			</div>
			<div class="row">
				<div class="title">주소</div>
				<div class="input">
					<input type="text" name="address" />
				</div>
			</div>
			<div>
				<input type="submit" value="회원가입" />
			</div>
		</div>
	</form>
</body>
</html>