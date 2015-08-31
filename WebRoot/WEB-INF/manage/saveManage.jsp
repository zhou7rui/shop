<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
    <title>添加</title>
    <style type="text/css">
    	form{
    		margin: 5px;
    	}
    </style>
    <script type="text/javascript">
    	$(function(){
    		$("input[name=type]").validatebox({
    			required:true,
    			missingMessage:'请输入类别名称'
    		});
    		//关闭验证
    		$("#ff").form("disableValidation");
    		//提交
    		$("#submit").click(function(){
    		$("#ff").form("enableValidation");
    			//判断验证是否成功
    			if($("#ff").form("validate")){
		    		//调用submit方法
		    		$('#ff').form('submit', {
						url: "manage_save.action",
						success: function(){
						//关闭Window
						parent.$("#win").window("close");
						}
					});
    		    }
    		});
    		
    	});
    </script>
    
    
  </head>
  <body>
  <form id="ff" method="post">   
    <div>   
        <label for="name">类别名称:</label>   
        <input  type="text" name="type" />   
    </div>   
    <div>   
        <label for="email">是否为热点:</label>   
       <input type="radio" name="hot" checked="checked" value="true" /> 是
       <input type="radio"name="hot" value="false" /> 否
    </div>     
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
  </form>  
    	
  </body>
</html>
