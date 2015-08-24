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
					columns : [ [ {
						field : 'code',
						title : 'Code',
						width : 100
					}, {
						field : 'name',
						title : 'Name',
						width : 100
					}, {
						field : 'price',
						title : 'Price',
						width : 100,
						align : 'right'
					} ] ]
				});

			});
		</script>
  	 
  </body>
</html>
