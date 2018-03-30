<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>小马的书店</title>
<link href="node_modules/bootstrap/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" href="//cdn.bootcss.com/weui/0.4.3/style/weui.min.css">
<link rel="stylesheet" href="node_modules/jquery-weui/dist/css/jquery-weui.min.css">

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<nav class="navbar navbar-default navbar-fixed-top"
					role="navigation">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle" data-toggle="collapse"
						data-target="#bs-example-navbar-collapse-1">
						<span class="sr-only">Toggle navigation</span><span
							class="icon-bar"></span><span class="icon-bar"></span><span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="#">小马书店</a>
				</div>

				<div class="collapse navbar-collapse"
					id="bs-example-navbar-collapse-1">
					
					
					<ul class="nav navbar-nav navbar-right">
						<li><a href="/bookstore/cart">购物车</a></li>
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown">账户<strong class="caret"></strong></a>
							<ul class="dropdown-menu">
								<li><a href="/bookstore/address">收货地址</a></li>
								<li><a href="/bookstore/order">我的订单</a></li>
							</ul></li>
					</ul>
				</div>

				</nav>
			</div>
		</div>
	</div>
	
<div class="row">
	<div id="goods" style="top:6rem;position:relative">
	</div>
</div>
	<script src="node_modules/jquery/dist/jquery.min.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<!-- <script src="node_modules/jquery-weui/dist/js/jquery.min.js"></script> -->
	<script src="node_modules/jquery-weui/dist/js/jquery-weui.min.js"></script>
	<script>
	$(document).ready(function () {
		$.ajax('index/findAll',{
			type:'POST', 
			data:{}, 
			contentType:'application/json',
			dataType:'json',
			success:function(data,XMLHttpRequest,jqXHR){
				$.each(data,function(index,item)
				{
					var div0=$("<div></div>").addClass("col-sm-6 col-md-3"),
					div1=$("<div></div>").addClass("thumbnail").css("position","relative"),
					img=$("<img src="+item.image+">"),
					div2=$("<div></div>").addClass("caption"),
					h3=$("<h3>价格:"+item.price+"</h3>"),
					p=$("<p></p>"),
					p1=$("<button id="+item.id+" value=buy onClick=buyOrAdd(this)>购买</button>").addClass("btn btn-primary"),
					p2=$("<button id="+item.id+" value=cart onClick=buyOrAdd(this)>加入购物车</button>").addClass("btn btn-default");
					div0.append(div1);
					div1.append(img);
					div1.append(div2);
					div2.append(h3);
					div2.append(p);
					p.append(p1);
					p.append(p2);
					$("#goods").append(div0);
				});
				
			},error:function(XMLHttpRequest,jqXHR){
				alert("erro");
			}
		});
	});
	function buyOrAdd(data){
		/* console.log(data.value); */
		/* alert(data.value); */
		 if(data.value=="buy")
		{
			/*  alert("执行购买操作"); */
			/* $.modal({
				  title: "付款",
				  text: "qing'xua",
				  buttons: [
				    { text: "支付宝", onClick: function(){buy()} },
				    { text: "微信支付", onClick: function(){ buy()} },
				    { text: "取消", className: "default", onClick: function(){buy()} },
				  ]
				}); 
			function buy(){ */
				alert("id是"+data.id);
		 		 $.ajax('order/buy?id='+data.id,{
					type:'POST', 
					data:{}, 
					contentType:'application/json',
					dataType:'json',
					success:function(data,XMLHttpRequest,jqXHR){
						alert("购买成功");
					},error:function(XMLHttpRequest,jqXHR){
						alert("购买错误");
					}
				});  
			/* } */
		} else{/* alert("id是"+data.id+"类型是"+$(data).val()); */
			$.ajax('shop/cart?id='+data.id,{
				type:'POST', 
				data:{}, 
				contentType:'application/json',
				dataType:'json',
				success:function(data,XMLHttpRequest,jqXHR){
					
				},error:function(XMLHttpRequest,jqXHR){
					alert("已添加至购物车！");
				}
			});
		}
		
	}
	</script>
</body>
</html>