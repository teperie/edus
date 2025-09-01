<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#bankheader {
	background-color: lightgray;
	padding: 100px;
}

h1 {
	text-align: center;
	padding: 10px auto;
	color: darkblue;
}

ul {
	margin: 5px;
}

li {
    display: inline-block;
	list-style: none;
	text-align: center;
	padding: 10px 20px;
}

li>a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div id="bankheader">
		<h1>
			<i>kosta bank</i>
		</h1>
		<div>
			<ul>
				<li><a href="makeAccount">계좌개설</a></li>
				<li><a href="deposit">입금</a></li>
				<li><a href="withdraw">출금</a></li>
				<li><a href="accountInfo">계좌조회</a></li>
				<li><a href="transfer">계좌이체</a></li>
				<li><a href="allAccountInfo">전체계좌조회</a></li>
			</ul>
		</div>
	</div>
</body>
</html>