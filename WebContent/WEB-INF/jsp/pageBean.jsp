<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">
ul {
	list-style: none; /* 去掉ul前面的符号 */
	margin: 0px; /* 与外界元素的距离为0 */
	padding: 0px; /* 与内部元素的距离为0 */
}

li {
	float: left;
}

ul li a, div.menu ul li a:visited {
	background-color: #465c71; /* 背景色 */
	border: 1px #4e667d solid; /* 边框 */
	color: #dde4ec; /* 文字颜色 */
	display: block; /* 此元素将显示为块级元素，此元素前后会带有换行符 */
	line-height: 1.35em; /* 行高 */
	padding: 4px 20px; /* 内部填充的距离 */
	text-decoration: none; /* 不显示超链接下划线 */
	white-space: nowrap; /* 对于文本内的空白处，不会换行，文本会在在同一行上继续，直到遇到 <br> 标签为止。 */
}

ul li a:hover {
	background-color: #bfcbd6; /* 背景色 */
	color: #465c71; /* 文字颜色 */
	text-decoration: none; /* 不显示超链接下划线 */
}
/* 所有class为menu的div中的ul中的a样式(鼠标点击元素时的样式) */
ul li a:active {
	background-color: #2e93db; /* 背景色 */
	color: #cfdbe6; /* 文字颜色 */
	text-decoration: none; /* 不显示超链接下划线 */
}
</style>
</head>
<body>
	<div id="menu">
		<ul>
			<li><a href="#">首页</a></li>
			<li><a href="#">上一页</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">下一页</a></li>
			<li><a href="#">尾页</a></li>
		</ul>
	</div>
</body>
</html>