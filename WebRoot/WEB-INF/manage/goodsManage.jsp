<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>商品管理</title>
	<%@ include  file="/public/head.jspf" %>
	<style type="text/css">
		*{margin:0;padding: 0}
	</style>
  </head>
  
  <body>

   <table id="dg"></table>  
  	
  	
  <script type="text/javascript">
  	$(function(){
  	
			$('#dg').datagrid({
					url : 'datagrid_data.json',
					fitColumns:true,			//自动适应宽度
					nowrap:true,
					striped:true, 				//显示斑马线	
					pagination:true,
					pageList:[10,20,30],
					frozenColumns:[[
						{field:'xyz',checkbox:true},
						{field : 'productid',title:'Code',width : 100}
					]],
					columns : [ [ {
	
						field : 'productname',
						title : 'Name',
						width : 100
					}, {
						field : 'listprice',
						title : 'Price',
						width : 100,
						align : 'right'
					} ] ]
				});

			});
		</script>
  	 
  </body>
</html>
