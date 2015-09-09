<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'bank.jsp' starting page</title>
	<%@ include file="/public/head.jspf" %>    
  </head>
  
  <body>
    <h1>银行页面</h1>
  </body>
</html>
