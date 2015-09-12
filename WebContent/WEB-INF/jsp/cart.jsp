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
<title>购物车</title>
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
	<h2>购物车</h2><a href="order/show">我的订单</a>
	<form action="order/place" method="post">
		<table>
			<tr background="#D5D5D5">
				<td>全选</td>
				<td>编号</td>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>商品描述</td>
				<td>商品价格</td>
				<td>商品库存量</td>
				<td>商品类别</td>
				<td>商品数量</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${pcList}" var="pc" begin="0" step="1" varStatus="s">
				<tr>	
					<td><input type="checkbox" name="productCategoryList[${s.index }].product.productId" value="${pc.product.productId }"></td>
					<td>${s.index+1 }</td>
					<td><img alt="" src="upload/${pc.product.img }" height="50px" width="50px"></td>
					<td>${pc.product.name }</td>
					<td>${pc.product.description }</td>
					<td>${pc.product.price }</td>
					<td>${pc.product.stock }</td>
					<td>${pc.category.name }</td>
					<td>
						<a href="cart/reduce/${pc.product.productId }">-</a> 
						<input type="text" value="${pc.number } " name="productCategoryList[${s.index }].number" style="width: 30px;">
						<a href="cart/plus/${pc.product.productId }">+</a>
					</td>
					<td><a href="cart/delete/${pc.product.productId }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="product/queryAll">继续购物</a>&nbsp;  
		<a href="cart/empty">清空购物车</a>&nbsp;
		<input type="submit" value="下一步">
	</form>
</body>
</html>