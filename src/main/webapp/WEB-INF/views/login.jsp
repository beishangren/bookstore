 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form action="<c:url value='/login.action'/>" method="post">
		<h1>商城登录</h1>
		<div class="form-group">
    		<label for="exampleInputEmail1">用户名</label>
    		<input type="text" class="form-control" name="userName">
  		</div>
		<div class="form-group">
    		<label for="exampleInputEmail1">密码</label>
    		<input type="password" class="form-control" name="passWord">
  		</div>
		<button type="submit" aligin="center" class="btn btn-default">登录</button><a href="register">尚未注册？</a>
	</form>
	<script src="<c:url value='/node_modules/jquery/dist/jquery.min.js'/>"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<script>
		
	</script>
</body>
</html>