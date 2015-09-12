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
<title>注册</title>
<script type="text/javascript">
//验证注册表单
	function checkForm(){
		// 将需要验证表单组件 提供id属性
		var username = document.getElementById("username").value;
		if(username==null||username==""){
			alert("用户名不能为空");
			return false;
		}	
		// 为其它字段添加非空校验
		var password = document.getElementById("password").value;
		var repassword = document.getElementById("repassword").value;
		if(password != repassword){
			alert("两次密码必须一致！");
			return false;
		}	
	}
	//切换验证码
	function change(){
		document.getElementById("myimg").src = "user/verifyCode?"+new Date().getTime();
	}
</script>
</head>
<body>
	<jsp:include page="navigate.jsp" />
	<h2>用户注册</h2>
	<form action="user/regist" method="post" onsubmit="checkForm();">
		用户&nbsp;名：<input type="text" name="username" id="username"/><br>
		密　　码：<input type="password" name="password" id="password"/><br>
		确认密码：<input type="password" id="repassword" /><br>
		性　　别：<input type="radio" name="gender" value="男" checked="checked"/>男&nbsp;&nbsp;
		   	  <input type="radio" name="gender" value="女"/>女<br>
		出生日期：<input type="text" name="birthday" /><br>
		身&nbsp;份证：<input type="text" name="idCard" /><br>
		邮　　箱：<input type="text" name="email" /><br>
		手　　机：<input type="text" name="mobile" /><br>
		地　　址：<input type="text" name="address" /><br>
		验证 码：<input type="text" name="checkcode"><img id="myimg" alt="单击换一张" src="user/verifyCode" onclick="change();"><br>
		<input type="submit" value="提交" />
	</form>
</body>
</html>