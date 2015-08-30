<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
  	<%@ include file="/public/head.jspf" %>
    <title>添加</title>
  </head>
  <body>
  <form id="ff" method="post">   
    <div>   
        <label for="name">品名:</label>   
        <input class="easyui-validatebox" type="text" name="name" data-options="required:true" />   
    </div>   
    <div>   
        <label for="email">是否为热点:</label>   
       <input type="radio" name="commend" checked="checked" value="true" /> 是
       <input type="radio"name="commend" value="false" /> 否
    </div>   
     <div>   
        <label for="email">Email:</label>   
        <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />   
    </div>   
     <div>   
        <label for="email">所属用户:</label>   
        <input class="easyui-validatebox" type="text" name="email" data-options="validType:'email'" />   
	</div>
	<div>
		<a id="submit" href="#" class="easyui-linkbutton">添 加</a> 
		<a id="reset" href="#" class="easyui-linkbutton">重 置</a>
	</div>
  </form>  
    	
  </body>
</html>
