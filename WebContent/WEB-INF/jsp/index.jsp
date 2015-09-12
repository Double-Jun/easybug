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
<title>easyBuy商城首页</title>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>easybuy商城首页</h2>
	<c:forEach items="${categoryCustoms }" var="categoryCustom">
		<a href="category/getById/${categoryCustom.category.categoryId }">${categoryCustom.category.name }</a>  >>
		<c:forEach items="${categoryCustom.childrenList }" var="children">
			<a href="category/getById/${children.categoryId }">${children.name }</a>
		</c:forEach>
		<br>
	</c:forEach>
</body>
</html>