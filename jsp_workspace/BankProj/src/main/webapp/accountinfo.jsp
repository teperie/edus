<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="dto.Account" %>    
<%@ page import="dto.SpecialAccount" %>    
<!-- acc 객체는 request에 이미 있음 -->
<!DOCTYPE html>
<html>
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
            width: 280px;
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
            float:left;
        }
    </style>
</head>
<body>
    <%@ include file="header.jsp" %>
        <div class="header"><h3>계좌조회</h3></div>
        <div class="container">
            <div class="row">
                <div class="title">계좌번호</div>
                <div class="input"><input type="text" disabled value="${acc.id}"></div>
            </div>
            <div class="row">
                <div class="title">이름</div>
                <div class="input"><input type="text" disabled value="${acc.name}"></div>
            </div>
            <div class="row">
                <div class="title">잔액</div>
                <div class="input"><input type="text" disabled value="${acc.balance}"></div>
            </div>
            <div class="row">
                <div class="title">종류</div>
                <div class="input">
                    <c:choose>
                        <c:when test="${isSpecial}">
                            <input type="text" disabled value="특수계좌">
                        </c:when>
                        <c:otherwise>
                            <input type="text" disabled value="일반계좌">
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <c:if test="${isSpecial}">
            <div class="row">
                <div class="title">등급</div>
                <div class="input">
                    <input type="text" disabled value="${grade}">
                </div>
            </div>
            </c:if>
        </div>
</body>
</html>