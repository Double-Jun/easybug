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
<title>订单确认</title>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
	<h2>我的订单</h2>
	<form action="order/verify" method="post">
		<table>
			<tr background="#D5D5D5">
				<td>编号</td>
				<td>商品图片</td>
				<td>商品名称</td>
				<td>商品描述</td>
				<td>商品价格</td>
				<td>商品库存量</td>
				<td>商品数量</td>
			</tr>
			<c:forEach items="${orderCustom.productCategoryList}" var="pc" begin="0" step="1" varStatus="s">
				<tr>	
					<td>${s.index+1 }</td>
					<td><img alt="" src="upload/${pc.product.img }" height="50px" width="50px">  </td>
					<td>${pc.product.name }</td>
					<td>${pc.product.description }</td>
					<td>${pc.product.price }</td>
					<td>${pc.product.stock }</td>
					<td>${pc.number }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="8" align="right">总价：${orderCustom.order.totalCost } 元</td>
			</tr>
		</table>
		<a href="cart/show">返回购物车重新挑选</a>
		<input type="submit" value="去结算">
	</form>
</body>
</html>