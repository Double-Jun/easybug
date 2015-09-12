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
<title>商品分类-${categories[0].category.name }</title>

<style type="text/css">
	div {
		margin-left:3px;
		width: 200px;
		hight:300px;
		border:solid 1px ;
		float: left;
	}
</style>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<form action="product/search" method="post">
		<input type="text" name="condition" />
		<input type="submit" value="搜索" /><br/>
	</form>
	商品分类ID：${pId }
	<h3>排序：&nbsp;<a href="index/sort/${pId }/price/${arg}">价格</a>
	<a href="index/sort/${pId }/sales/${arg}">销售量</a>
	<a href="">好评</a></h3>
	<c:forEach items="${categories }" var="category">
		<div>
			<img alt="${category.product.description }" src="upload/${category.product.img }" height="200px" width="200px"><br>
			名称：${category.product.name } <br>
			价格：￥:${category.product.price } <br>
			销量：${category.product.sales } <br>
		</div>
	</c:forEach>
	<br>
	<%-- <div id="pageBean"><jsp:include page="pageBean.jsp" /></div> --%>
</body>
</html>