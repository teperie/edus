<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<style>
	#bankHeader {
		background-color: lightgray;
		height:100px;
	}
	
	h1 {
		text-align: center;
		padding: 10px auto;
	}
	
	ul {
		margin: 5px;		
	}
	
	li {
		display: inline-block;
		list-style: none;
		float: left;
		text-align: center;
		padding-right: 15px;
	}
	
	li>a {
		text-decoration: none;
	}
</style>
<div id="bankHeader">
	<h1><i>kosta bank</i></h1>
	<div>
		<ul style="float:left">
			<li><a href="makeAccount">계좌개설</a></li>
			<li><a href="deposit">입금</a></li>
			<li><a href="withdraw">출금</a></li>
			<li><a href="accountInfo">계좌조회</a></li>
			<li><a href="transfer">계좌이체</a></li>
			<li><a href="allAccountInfo">전체계좌조회</a></li>			
		</ul>
		
		<ul style="float:right">
			<li>
				<c:choose>
					<c:when test="${user == null}">
						<a href="login">로그인</a>
					</c:when>
					<c:otherwise>
						${user.id }님 환영합니다.&nbsp;&nbsp;
						<a href="logout">로그아웃</a>
					</c:otherwise>
				</c:choose>
			</li>
			<li><a href="join">회원가입</a></li>
		</ul>
	</div>
</div>