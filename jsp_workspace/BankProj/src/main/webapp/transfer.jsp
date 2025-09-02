<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            width: 310px;
            padding: 10px;
        }
        .row {
            height: 30px;
        }
        .title {
            float: left;
            width: 120px;
            text-align: center;
            font-weight: bold;
        }
        .input {
            float:left;
        }
        input[type='submit'] {
            font-weight: bold;
            width: 120px;
            background-color: lightgray;
            display: block;            
            margin: 0 auto;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
    <form action="transfer" method="post">
        <div class="header"><h3>계좌송금</h3></div>
        <div class="container">
            <c:if test="${not empty errorMsg}">
                <div style="color:red; text-align:center;">${errorMsg}</div>
            </c:if>
            <div class="row">
                <div class="title">보내는계좌번호</div>
                <div class="input"><input name="sid" type="text" value="${param.sid}"></div>
            </div>
            <div class="row">
                <div class="title">받는계좌번호</div>
                <div class="input"><input name="rid" type="text" value="${param.rid}"></div>
            </div>
            <div class="row">
                <div class="title">송금액</div>
                <div class="input"><input name="money" type="text" value="${param.money}"></div>
            </div>
            <div class="button">
                <input type="submit" value="송금">
            </div>
        </div>

    </form>
</body>
</html>