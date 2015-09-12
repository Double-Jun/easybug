<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆</title>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>用户登陆</h2>
	<form action="user/login" method="post">
		用户名：<input type="text" name="username"> <br>
		密&nbsp;码：<input type="password" name="password"> <br>
		<input type="submit" value="登陆">
		<a href="user/registUI">还没注册，先去注册...</a>
	</form>
</body>
</html>