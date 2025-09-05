<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
	border-top: 1px solid;
	border-bottom: 1px solid;
}

.title {
	font-weight: bold;
	background-color: lightgray;
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
$(function() {
	$("#more").click(function() {
		$.ajax({
			url:"accountMore",
			type:"get",
			async:true,
			contentType: "application/json; charset=UTF-8",
			dataType:"json",
			data:{page:+$(this).data("page")+1},
			success:function(result) {
				console.log(result.accList)
				console.log(result.curPage)
				console.log(result.allPage)
				$("#more").text(result.curPage+"/"+result.allPage)
				if(result.curPage==result.allPage) {
					$("#more").attr("disabled","true");
				}
				let sequence = (result.curPage-1)*5;
				result.accList.forEach((acc)=> {
					$("#container").append($(`<div class="row">
				   	    	<div class="column">\${++sequence}</div>
				           	<div class="column">\${acc.id }</div>
					    	<div class="column">\${acc.name }</div>
				           	<div class="column">\${acc.balance }</div>
				           	<div class="column">\${acc.type }</div>
				           	<div class="column">\${acc.grade }</div>
				           	</div>`))
				})
			},
			error:function(err) {
				console.log(err)
			}
		})
	})
})

</script>

</head>
<body>
	<%@ include file="header.jsp"%>
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
		<c:forEach items="${accList}" varStatus="status" var="acc">
			<div class="row">
				<div class="column">${status.index+1 }</div>
				<div class="column">${acc.id }</div>
				<div class="column">${acc.name }</div>
				<div class="column">${acc.balance }</div>
				<div class="column">${acc.type }</div>
				<div class="column">${acc.grade }</div>
			</div>
		</c:forEach>
	</div>
	<br>
	<br>
	<div class="more">
		<button id="more" ${curPage==allPage? 'disabled':'' }
			data-page='${curPage}'>${curPage }/${allPage }</button>
	</div>
</body>
</html>