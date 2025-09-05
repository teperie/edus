<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
	let pers = [ {
		id : "hong",
		name : "gildong",
		age : 20
	}, {
		id : "kim",
		name : "yuna",
		age : 22
	}, {
		id : "park",
		name : "chanyeol",
		age : 21
	} ];

	$(function() {
		$("#btn1").click(function() {
			$.ajax({
				url : 'json7',
				type : 'post',
				async : true,
				data : {
					param : JSON.stringify(pers)
				},
				success : function(data) {
					console.log(data);
				}
			})
		})
	})
</script>
</head>
<body>
<button id="btn1">전송</button>
</body>
</html>