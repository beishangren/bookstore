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
	<!-- <nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
    <div class="navbar-header">
        <a class="navbar-brand" href="#">管理端</a>
    </div>
    <div>
        <form class="navbar-form navbar-left" role="search">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button type="button" class="btn btn-primary" data-toggle="modal"
		data-target=".bs-example-modal-sm">查看书店基本信息</button>
        </form>
        <button type="button" class="btn btn-default navbar-btn">
            导航栏按钮
        </button>
    </div>
	</div>
</nav>
	

	<div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog"
		aria-labelledby="mySmallModalLabel">
		<div class="modal-dialog modal-sm" role="document">
			<div class="modal-content">
			收益:<input value="100000"/><br />
			书本数量:<input value="10000"/>
			</div>
		</div>
	</div> -->
<ul id="myTab" class="nav nav-tabs">
	<li class="active">
		<a href="#order" data-toggle="tab">
			订单管理
		</a>
	</li>
	<li><a href="#uploadBooks" data-toggle="tab">书籍上传</a></li>
	<li class="dropdown">
		<a href="#" id="myTabDrop1" class="dropdown-toggle" 
		   data-toggle="dropdown">其他 
			<b class="caret"></b>
		</a>
		<ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
			<li><a href="#income" tabindex="-1" data-toggle="tab">收益</a></li>
			<li><a href="#set" tabindex="-1" data-toggle="tab">设置</a></li>
		</ul>
	</li>
</ul>

<div id="myTabContent" class="tab-content">

	<div class="tab-pane fade in active" id="order">
		<h1>订单</h1>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>商品名称</th>
					<th>价格</th>
					<th>订单编号</th>
					<th>状态</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th>信息论编码</th>
					<th>56￥</th>
					<th>165462135465613</th>
					<th>已发货</th>
				</tr>
				<tr>
					<th>数学分析(上下)</th>
					<th>126￥</th>
					<th>798462135465613</th>
					<th>待发货</th>
				</tr>
				<tr>
					<th>空间解析几何</th>
					<th>78￥</th>
					<th>556221354689613</th>
					<th>已签收</th>
				</tr>
			</tbody>
		</table>
	</div>
	
	<div class="tab-pane fade" id="uploadBooks">
		书名:<input type="text" id="name" /><br/>
		价格:<input type="text" id="price" /><br/>
		数量:<input type="text" id="number" /><br/>
		图片:<div style="width:30%;">
        	<div class="col-lg-8" id='myfile'>
            	<input type="file" name="myfile" data-path="1" data-ref="url2" class="col-sm-10 myfile" value="" /> 
                <input type="hidden" name="url2" value="">
            </div>
         </div><br />
       <button id="submit">上传</button>
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
	$('.myfile').fileinput('destroy');
    $(".myfile").fileinput({
       //上传的地址
       /* uploadUrl:"/zfm-fileupload/rest/document", */
       /* uploadAsync : true, //默认异步上传 */
       /* showUpload : true, //是否显示上传按钮,跟随文本框的那个 */
       showCaption : true,//是否显示标题,就是那个文本框
       showPreview : true, //是否显示预览,不写默认为true
       dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
       maxFileCount : 1, //表示允许同时上传的最大文件个数
       enctype : 'multipart/form-data',
       validateInitialCount : true,
       previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
       msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
       allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
       allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
       allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
       language : 'zh'
   }) 
/*    //异步上传返回结果处理
   $('.myfile').on('fileerror', function(event, data, msg) {
       console.log("fileerror");
       console.log(data);
   });
   //异步上传返回结果处理(返回上传地址)
   $(".myfile").on("fileuploaded", function(event, data, previewId, index) {
       console.log("fileuploaded",data.response);
       var ref = $(this).attr("data-ref");
       $("input[name='" + ref + "']").val(data.response.url);

   });

   //同步上传错误处理
   $('.myfile').on('filebatchuploaderror', function(event, data, msg) {
       console.log("filebatchuploaderror");
       console.log(data);
   });

   //同步上传返回结果处理
   $(".myfile").on("filebatchuploadsuccess",
           function(event, data, previewId, index) {
               console.log("filebatchuploadsuccess");
               console.log(data);
           }); */

   //上传前
   $('.myfile').on('filepreupload', function(event, data, previewId, index) {
       console.log("filepreupload");
   });
   
 function uploadPicture(){
	$('.myfile').fileinput('destroy');
   $(".myfile").fileinput({
      //上传的地址
      uploadUrl:"/zfm-fileupload/rest/document",
      /* uploadAsync : true, //默认异步上传 */
      showUpload : true, //是否显示上传按钮,跟随文本框的那个
      showCaption : true,//是否显示标题,就是那个文本框
      showPreview : true, //是否显示预览,不写默认为true
      dropZoneEnabled : false,//是否显示拖拽区域，默认不写为true，但是会占用很大区域
      maxFileCount : 1, //表示允许同时上传的最大文件个数
      enctype : 'multipart/form-data',
      validateInitialCount : true,
      previewFileIcon : "<i class='glyphicon glyphicon-king'></i>",
      msgFilesTooMany : "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
      allowedFileTypes : [ 'image' ],//配置允许文件上传的类型
      allowedPreviewTypes : [ 'image' ],//配置所有的被预览文件类型
      allowedPreviewMimeTypes : [ 'jpg', 'png', 'gif' ],//控制被预览的所有mime类型
      language : 'zh'
  })
  $(".myfile").on("filebatchuploadsuccess",
          function(event, data, previewId, index) {
              console.log("filebatchuploadsuccess");
              console.log(data);
          });
}

function picturePath(){
	$(".myfile").on("fileuploaded", function(event, data, previewId, index) {
       console.log("fileuploaded",data.response);
       
       var ref = $(this).attr("data-ref");
       $("input[name='" + ref + "']").val(data.response);

   });
	return $("input[name='url2']").val();

}
$("#submit").click(function(){
	var img= $("#myfile .file-input .file-preview .file-drop-disabled " +
		".file-preview-thumbnails .file-preview-frame .kv-file-content img");
	var file =img.attr('src');
	data1={
		name:$("#name").val(),
		price:$("#price").val(),
		number:$("#number").val(),
		image:file,
			
	};
	console.log(name+price+number+file);
	$.ajax('book/create',{
		type:'POST',
		data:JSON.stringify(data1),
		contentType:'application/json',
		dataType:'json',
		success:function(data,XMLHttpRequest,jqXHR){
			if(data.name=="1"){
				alert("success!");
			}
		},error:function(XMLHttpRequest,jqXHR){
			alert("erro");
		}
	});
})
	</script>
</body>
</html>