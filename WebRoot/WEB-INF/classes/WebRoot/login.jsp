<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <meta charset="utf-8">
    <title>login</title>
  </head>
  <body>
    <form action="login" method="post">
    	<div class="userName">
    		<label>用户名：</label>
    		<input type="text" name="userName"/>
    	</div>
    	<div class="pwd">
    		<label>密码：</label>
    		<input type="password" name="pwd"/>
    	</div>
    	<div class="submit">
    		<input  type="submit" value="登录"/>
    	</div>
    </form>
  </body>
</html>
