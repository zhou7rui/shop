<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML>
<html>
  <head>
    <title>后台管理</title>
    <%@ include file="/public/head.jspf" %>
  </head>
  
  <body class="easyui-layout"> 
    <div data-options="region:'north',title:'易购商城',split:true" style="height:80px;"></div>   
    <div data-options="region:'west',title:'菜单管理',split:true" style="width:150px;">
	  <div id="aa" class="easyui-accordion" data-options="fit:true">
	    <div title="后台管理"> 
	      <ul id="tt" class="easyui-tree">   
    	    <li>   
              <span>订单管理</span> 
              <ul>
                <li>
                  	商品订单
                </li>
                <li>
                  	商品订单
                </li>
              </ul>  
            </li>
    	    <li>   
              <span>用户管理</span>   
              <ul>
              	<li></li>
              </ul>
            </li>
          </ul>   
		</div>
		<div title="系统设置">

		</div>
	  </div>
	</div>   
    <div data-options="region:'center',title:'Home'" style="padding:5px;background:#eee;"></div>   
  </body>
</html>
