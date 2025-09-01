<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<%@ include file="header.jsp" %>
	<form action="join" method="post">
		<div><h3 class="header">회원가입</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id" id="id" style="width:120px"/></div>
				<div class="input">&nbsp;<button name="action" value="duplicate" id="doubldId">중복</button></div>
				<div class="input">&nbsp;<span id="msg">

					<% if(request.getAttribute("msg") != null) { %>
						<%= request.getAttribute("msg") %>
					<% } %>

				</span></div>
			</div>
			<div class="row">  
				<div class="title">이름</div>
				<div class="input"><input type="text" name="name" value="<%= request.getAttribute("name") %>" />
					
				</div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text" name="password" value="<%= request.getAttribute("password") %>"/>
					
				</div>
			</div>
			<div class="row">  
				<div class="title">이메일</div>
				<div class="input"><input type="text" name="email" value="<%= request.getAttribute("email") %>"/>
					
				</div>
			</div>
			<div class="row">  
				<div class="title">주소</div>
				<div class="input"><input type="text" name="address" value="<%= request.getAttribute("address") %>"/>
					
				</div>
			</div>
			<div>
				<input name="action" type="submit" value="회원가입"/>
			</div>
		</div>
	</form>
</body>
</html>