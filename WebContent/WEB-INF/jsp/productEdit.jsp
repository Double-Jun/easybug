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
<title>商品修改</title>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>商品修改</h2>
	<form action="product/edit" method="post" enctype="multipart/form-data">
	 			<%--商品id隐藏字段，必须要有，因为商品是根据此id修改数据库对饮id商品信息 --%>
			  <input type="hidden" name="productId" value="${product.productId }"> 
		商品名称：<input type="text" name="name" value="${product.name }"/><br>
		价　　格：<input type="text" name="price" value="${product.price }"/><br>
		库　　存：<input type="text" name="stock" value="${product.stock }"/><br>
		商品分类：<select name="categoryId" onclick="${product.categoryId}">
				<c:forEach var="category" items="${categoryList }" >
					<!-- togo:这里数据没有数据回显，后面处理 -->
					<option value="${category.categoryId }" >${category.name }</option>
				</c:forEach>
			</select><br>
			<%--图片没有显示 --%>
		商品图片：<input type="file" name="productImg" /><img alt="商品图片" src="${product.img }"><br>
		商品描述：<textarea name="description" rows="6" cols="30" >${product.description }</textarea><br>
		<input type="submit" value="提交修改" />
	</form>
</body>
</html>