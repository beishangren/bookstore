<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<h1>注册</h1>
		<div class="form-group">
    		<label for="exampleInputEmail1">用户名</label>
    		<input type="text" class="form-control" id="username">
  		</div>
		<div class="form-group">
    		<label for="exampleInputEmail1">密码</label>
    		<input type="password" class="form-control" id="password">
  		</div>
	<button type="submit" id="register" class="btn btn-default">提交</button>
	<script src="node_modules/jquery/dist/jquery.min.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<script type="text/javascript">
		$("#register").click(function() {
			var name = $("#username").val();

			data1 = {
				userName : $("#username").val(),
				passWord : $("#password").val(),
			};
			console.log(data1);
			$.ajax('user/create', {
				type : 'POST',
				data : JSON.stringify(data1),
				contentType : 'application/json',
				dataType : 'json',
				success : function(data, XMLHttpRequest, jqXHR) {
					alert("成功");
				},
				error : function(XMLHttpRequest, jqXHR) {
					alert("失败");
				}
			});
		});
	</script>
</body>

</html>