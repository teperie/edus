<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ page import="dto.Account"%>
<%@ page import="dto.SpecialAccount"%>
<%
List<Account> accs = (List<Account>) request.getAttribute("accs");
%>
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
<%@ include file="header.jsp" %>
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
			<%for (int i = 0; i < accs.size(); i++) {
			Account acc = accs.get(i);%>
			<div class="row">
				<div class="column"><%=i + 1%></div>
				<div class="column"><%=acc.getId()%></div>
				<div class="column"><%=acc.getName()%></div>
				<div class="column"><%=acc.getBalance()%></div>
				<div class="column">
					<%if (acc instanceof SpecialAccount) {%>
						특수게좌
					<%} else {%>
						일반계좌
					<%}%>
				</div>
				<div class="column">
					<%if (acc instanceof SpecialAccount) {%>
						<%=((SpecialAccount) acc).getGrade()%>
					<%}%>
				</div>
			</div>
			<%}%>
		</div>
	</form>
</body>
</html>