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
<title>Insert title here</title>
</head>
<body>
	<h3>
		<a href="user/loginUI">登陆</a>
		<a href="user/registUI">注册</a>
		<a href="product/queryAll">查看所有商品</a>
		<a href="product/addUI">添加商品</a>
		<a href="cart/show">查看购物车</a>
		<a href="index">首页</a>
	</h3>
</body>
</html>