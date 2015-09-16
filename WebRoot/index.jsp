<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>易购商城</title>
	<%@ include file="/public/head.jspf" %>
</head>

<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
        <!-- 头部结束 -->

        <div class="section_container">
            <!--左侧导航-->
            <div id="side_nav">
                <div class="sideNavCategories">
                    <h1>女装</h1>
                    <ul class="category departments">
                        <li class="header">分类</li>
                        <li><a href="#">毛衣</a></li>
                        <li><a href="#">针织衫 </a></li>
                        <li><a href="#">衬衫 </a></li>
                        <li><a href="#">T恤</a></li>
                        <li><a href="#">短裤</a></li>
                        <li><a href="#">牛仔 </a></li>
                        <li><a href="#">连身裙</a></li>
                        <li><a href="#">短裙 </a></li>
                    </ul>
                </div>
                
            </div>
            <!-- 右侧焦点图区域 -->
            <div id="main_content ">
                <div > <img src="images/lm_banner_1.jpg" /> </div>
            </div>
        </div>
			
			<c:forEach items="${applicationScope.proList}" var="list">
            <!-- 产品列表 -->
            <div class="products_list products_slider clear">
                <h2 class="sub_title" >${list[0].cid.type}</h2>
                <ul id="first-carousel" class="first-and-second-carousel jcarousel-skin-tango">
                	<c:forEach items="${list}" var="product">
                    <li> 
                    <a  href="${shop}/product_queryByid?id=${product.id}" class="product_image"><img src="images/${product.pic}" /></a>
                        <div class="product_info">
                            <h3><a href="#">${product.name}</a></h3>
                            <small>${product.remark}</small> 
                         </div>
                        <div class="price_info"> 
                           <button><span class="pr_add"><a href="sorder_addsorder?product.id=${product.id}">添加购物车</a></span></button>
                           <button class="price_add" title="" type="button"><span class="pr_price">${product.price}</span></button>
                        </div>
                    </li>
                    </c:forEach>
                 </ul>
            </div>
           </c:forEach>
        <!--产品列表结束  --> 
        <!-- 导航栏结束 -->
        <!-- 尾部导入 -->
        <jsp:include page="/public/tail.jsp"></jsp:include>
     </div>
</body>

</html>
