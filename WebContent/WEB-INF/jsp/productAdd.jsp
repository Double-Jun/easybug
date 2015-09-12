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
<title>商品添加</title>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>商品添加</h2>
	<form action="product/add" method="post" enctype="multipart/form-data">
		商品名称：<input type="text" name="name" /><br>
		价　　格：<input type="text" name="price" /><br>
		库　　存：<input type="text" name="stock" /><br>
		商品分类：<select name="categoryId">
				<c:forEach var="category" items="${categoryList }">
					<option value="${category.categoryId }">${category.name }</option>
				</c:forEach>
			</select><br>
		商品图片：<input type="file" name="productImg" /><br>
		商品描述：<textarea name="description" rows="6" cols="30" ></textarea><br>
		<input type="submit" value="添加商品" />
	</form>
</body>
</html>