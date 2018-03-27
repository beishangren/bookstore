<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>书店管理</title>
<link href="node_modules/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<c:url value='/node_modules/bootstrap-fileinput/css/fileinput.min.css'/>">

</head>
<body>
<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#order" data-toggle="tab">
			购物车
		</a>
	</li>
	<li>
		<a href="#uploadBooks" data-toggle="tab">订单状态</a>
	</li>

</ul>

<div id="myTabContent" class="tab-content">

	<div class="tab-pane fade in active" id="order">
		<h1>购物车</h1>
		<table class="table table-hover" >
			<thead>
				<tr>
					<th>商品名称</th>
					<th>价格</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="cart">
				
			</tbody>
		</table>
	</div>
		
	<div class="tab-pane fade" id="uploadBooks">
		<h1>订单列表</h1>
		<table class="table table-hover" >
			<thead>
				<tr>
					<th>商品</th>
					<th>价格</th>
					<th>状态</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="orderList">
				
			</tbody>
		</table>	
	</div>
	
	<div class="tab-pane fade" id="income">
		<h1>收益</h1>
	</div>
	
	<div class="tab-pane fade" id="set">
		<h1>设置</h1>
	</div>
	
</div>
	<script src="node_modules/jquery/dist/jquery.min.js"></script>
	<script src="node_modules/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="<c:url value='/node_modules/bootstrap-fileinput/js/fileinput.min.js'/>"></script>
	
	<script type="text/javascript">
	$(document).ready(function () {
		$.ajax('shop/findCart',{
			type:'POST', 
			data:{}, 
			contentType:'application/json',
			dataType:'json',
			success:function(data,XMLHttpRequest,jqXHR){
				console.log(data);
				$.each(data,function(index,item)
				{
					var tr=$("<tr></tr>"),
					th1=$("<th>"+item.name+"</th>"),
					th2=$("<th>"+item.price+"￥</th>"),
					th3=$("<th><button id="+item.id+" onClick=buy(this)>购买</button></th>")
					tr.append(th1);
					tr.append(th2);
					tr.append(th3);
					$("#cart").append(tr);
				});
				
			},error:function(XMLHttpRequest,jqXHR){
				alert("erro");
			}
		});
		
 		$.ajax('order/findOrder',{
			type:'POST', 
			data:{}, 
			contentType:'application/json',
			dataType:'json',
			success:function(data,XMLHttpRequest,jqXHR){
				if(data!=null){
					var state=null;
					$.each(data,function(index,item)
							{
								var th4=$("<th><button disabled=true style=background:#CFCFCF id="+item.id+" onClick=buy(this)>确认收货</button></th>");

								if(item.state=="buy"){
									state="待发货"
								}
								if(item.state=="delivery"){
									state="已发货"
								}
								if(item.state=="complete"){
									state="交易完成"
									th4=$("<th><button style=background:skyblue id="+item.id+" onClick=buy(this)>确认收货</button></th>");
								}
								var tr=$("<tr></tr>"),
								th1=$("<th>"+item.bookName+"</th>"),
								th2=$("<th>"+item.price+"￥</th>"),
								th3=$("<th>"+state+"</th>");
								
								tr.append(th1);
								tr.append(th2);
								tr.append(th3);
								tr.append(th4);
								$("#orderList").append(tr);
							});
				}
				
				
			},error:function(XMLHttpRequest,jqXHR){
				alert("erro");
			}
		});
	});
	
	function buy(data){
		alert("id是"+data.id);
 		 $.ajax('order/buy?id='+data.id,{
			type:'POST', 
			data:{}, 
			contentType:'application/json',
			dataType:'json',
			success:function(data,XMLHttpRequest,jqXHR){
			
			},error:function(XMLHttpRequest,jqXHR){
			
			}
		});  
	}
	</script>
</body>
</html>