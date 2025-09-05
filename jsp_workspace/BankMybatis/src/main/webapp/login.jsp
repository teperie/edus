<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<c:set var="contextPath" value='${pageContext.request.contextPath}'/>    
<%-- <%
	String id = null;
	String password =null;
	String autoLogin=null;
	String cookie = request.getHeader("Cookie");
	if(cookie != null) {
		Cookie cookies[] = request.getCookies();
		for(int i=0; i<cookies.length; i++)  {
			if(cookies[i].getName().equals("id")) {
				id=cookies[i].getValue();
			} else if(cookies[i].getName().equals("password")) {
				password=cookies[i].getValue();
			} else if(cookies[i].getName().equals("autoLogin")) {
				autoLogin=cookies[i].getValue();
			}
		}
	}
%> --%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="./css/common.css" rel="stylesheet">
</head>

<body>
	
	<jsp:include page="header.jsp"/>
	${id }
	${password }
	<form action="${contextPath}/login" method="post">
		<div><h3 class="header">로그인</h3></div>
		<div class="wrap">
			<div class="row">  
				<div class="title">아이디</div>
				<div class="input"><input type="text" name="id" value="${id}"/></div>
			</div>
			<div class="row">  
				<div class="title">비밀번호</div>
				<div class="input"><input type="text" name="password" value="${password}"/></div>
			</div>
			<div class="row">
				<input type="checkbox" name="autologin" class="title" value="true" ${autoLogin ne null? "checked":"" }>
				<b>자동로그인</b>
			</div>
			<div>
				<input type="submit" value="로그인"/><br>
			</div>
		</div>
	</form>
</body>
</html>