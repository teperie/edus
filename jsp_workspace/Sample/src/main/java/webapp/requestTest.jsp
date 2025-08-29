<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
requestUrl: <%=request.getRequestURL() %> <br />
requestUri: <%=request.getRequestURI() %> <br />
remoteHost: <%=request.getRemoteHost() %> <br />
remoteAddr: <%=request.getRemoteAddr() %> <br />
protocol: <%=request.getProtocol() %> <br />
serverName: <%=request.getServerName() %> <br />
serverPort: <%=request.getServerPort() %><br />
method: <%=request.getMethod() %><br />
contextPath: <%=request.getContextPath() %><br />
queryString: <%=request.getQueryString() %><br />
<%=request.getParameter("test") %><br />
<%=request.getParameterMap() %><br />

</body>
</html>