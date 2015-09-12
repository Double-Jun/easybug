<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品列表</title>
<style type="text/css">
	table{
		border: 1px; 
		width: 100%; 
		border-collapse: collapse;
	}
	td {
    vertical-align: text-top;
    padding: 6px 15px 6px 6px;
    background-color: #EFEFEF;
    border: 1px solid #AAA;
}
</style>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>商品列表</h2>
	<table border="1" width="100%">
		<tr>
			<td>编号</td>
			<td>商品图片</td>
			<td>商品名称</td>
			<td>商品描述</td>
			<td>商品价格</td>
			<td>库存量</td>
			<td>商品类别</td>
			<td>操作</td>
		</tr>
		<c:forEach items="${productList }" var="product"  varStatus="s">
			<tr>
				<td>${s.index+1 }</td>
				<td><img alt="商品图片" src="upload/${product.img }" height="100px" width="100px"></td>
				<td>${product.name }</td>
				<td>${product.description }</td>
				<td>${product.price }</td>
				<td>${product.stock }</td>
				<td>${product.categoryId }</td>
				<td><a href="product/delete/${product.productId }">删除</a>&nbsp;
					<a href="product/editUI/${product.productId }">修改</a>&nbsp;
					<a href="cart/add/${product.productId }">加入购物车</a>&nbsp;
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="product/addUI">添加</a>
	<a href="cart/show">查看我的购物车</a>
</body>
</html>