<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="contextPath" value='${pageContext.request.contextPath}' />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계좌개설</title>
<style>
.header {
	text-align: center;
}

.container {
	margin: 0 auto;
	border: 1px solid;
	width: 300px;
	padding: 10px;
}

.row {
	height: 30px;
}

.title {
	float: left;
	width: 70px;
	text-align: center;
	font-weight: bold;
}

.input {
	float: left;
}

input[type='submit'] {
	font-weight: bold;
	width: 120px;
	background-color: lightgray;
	display: block;
	margin: 0 auto;
}
</style>
<script>
        window.onload = function() {
            let select = document.querySelector("#grade");
            let types = document.querySelectorAll("input[name='type']");
            for(type of types) {
                type.onclick = function() {
                    if(this.checked && this.value=='특수계좌') {
                        select.disabled = false;
                    } else {
                        select.disabled = true;
                    }
                }
            }
            
            let doubleAccBtn = document.querySelector("#doubleAccount");
            doubleAccBtn.onclick = function(e) {
                e.preventDefault();
                let id = document.querySelector("#id").value;
                if(id=='') {
                    alert("계좌번호를 입력하세요");
                    document.querySelector("#id").focus();
                    return;
                }
                let xhr = new XMLHttpRequest();
                xhr.open("post", `${contextPath}/accountCheck`, true);
                xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
                xhr.onreadystatechange = function() {
                    if(xhr.readyState==4 && xhr.status==200) {
                        let result = xhr.responseText;
                        if(result=='true') {
                            alert("중복된 계좌번호입니다.");
                        } else if(result=='false') {
                            alert("사용 가능한 계좌번호입니다.");
                        } else {
                            alert("에러 발생");
                        }
                    }
                }
                xhr.send(`id=\${id}`);
            }
           /*  let form = document.forms[0];
            form.onsubmit = function(e) {
                let id = form.elements.id.value;
                let name = form.elements.name.value;
                let balance = form.elements.balance.value;
                let type = document.querySelector("input[name='type']:checked").value;
                let grade = ''
                if(type=='special') {
                    //grade = document.querySelector("#grade>option:checked").value
                    grade = document.querySelector("#grade").value;
                } 
                console.log(`계좌번호:${id},이름:${name},잔액:${balance},종류:${type},등급:${grade}`);
                return false;
            } */
        }
    </script>
</head>
<body>
	<%-- 	<%@ include file="header.jsp" %> --%>
	<jsp:include page="header.jsp" />
	<form action="${contextPath}/makeAccount" method="post">
		<div class="header">
			<h3>계좌개설</h3>
		</div>
		<div class="container">
			<div class="row">
				<div class="title">계좌번호</div>
				<div class="input">
					<input type="text" name="id" id="id"> <input
						id="doubleAccount" type="button" value="중복">
				</div>
			</div>
			<div class="row">
				<div class="title">이름</div>
				<div class="input">
					<input type="text" name="name" id="name">
				</div>
			</div>
			<div class="row">
				<div class="title">입금액</div>
				<div class="input">
					<input type="text" name="balance" id="balance">
				</div>
			</div>
			<div class="row">
				<div class="title">종류</div>
				<div class="input">
					<input type="radio" name="type" checked value="일반계좌">일반 <input
						type="radio" name="type" value="특수계좌">특수
				</div>
			</div>
			<div class="row">
				<div class="title">등급</div>
				<div class="input">
					<select name="grade" id="grade" disabled>
						<option>선택</option>
						<option value="VIP">VIP</option>
						<option value="Gold">Gold</option>
						<option value="Silver">Silver</option>
						<option value="Normal">Normal</option>
					</select>
				</div>
			</div>
			<div class="button">
				<input type="submit" value="개설">
			</div>
		</div>

	</form>
</body>
</html>