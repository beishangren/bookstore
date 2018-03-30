<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>注册</h1>
	用户名：
	<input id="username" />
	<br /> 密 码：
	<input id="password" />
	<br />
	<button type="button" id="register">提交</button>
	<script src="node_modules/jquery/dist/jquery.min.js"></script>
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