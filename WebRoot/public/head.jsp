<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set value="${pageContext.request.contextPath}" var="shop"></c:set>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<div class="header">
	<div class="header_container">
		<!--头部开始-->
		<div class="top_bar clear">
			<!--头部小导航-->
			<div class="welcom fl">欢迎光临LEISUPET SHOP!</div>
			<ul class="top_links fr">
				<li class="highlight"><a href="index.jsp">首页</a></li>
				<li><a href="#">我的账户</a></li>
				<li><a href="showCar.jsp">购物车</a></li>
				<c:choose>
					<c:when test="${empty sessionScope.userInfo}">
						<li><a href="#">注册</a></li>
						<li><a href="ulogin.jsp">登录</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="#">${userInfo.name}</a></li>
						<li><a href="user_logout">退出</a></li>
					</c:otherwise>
				</c:choose>
			</ul>
			<!--头部小导航结束-->
			<!-- logo -->
			<h1 class="logo clear fl">
				<a href="index.html"><img src="${shop}/images/logo.png" /></a>
			</h1>
			<!-- 购物车 -->
			<div class="minicart">
				<a class="minicart_link" href="showCar.jsp"> <span class="item">
						<b>${fn:length(sessionScope.forder.sorders)}</b> 件/
				</span> <span class="price"> <b>￥${sessionScope.forder.price}</b>
				</span>
				</a>
			</div>
			<!-- 购物车结束 -->
			<!-- 搜索框 -->
			<div class="header_search">
				<div class="form-search ">
					<input value="请输入商品名称" class="input-text" type="text" />
					<button type="submit" title="Search"></button>
				</div>
			</div>
		</div>
	</div>
</div>
<!-- 导航栏 -->
<div class="navigation_container">
	<!---->
	<div class="nav">
		<ul class="primary_nav">
			<li class="active highlight"><a href="#">女装</a> <!--二级菜单-->
				<ul class="sub_menu">
					<li><a href="#">裙装</a>
						<ul>
							<li><a href="#">短裙</a></li>
							<li><a href="#">短裤 </a></li>
							<li><a href="#">裤子</a></li>
							<li><a href="#">卡其裤</a></li>
							<li><a href="#">休闲裤</a></li>
							<li><a href="#">牛仔裤</a></li>
							<li><a href="#">风衣 & 运动夹克</a></li>
						</ul></li>

				</ul></li>
			<!--二级菜单结束-->

			<li><a href="#">男装</a> <!--二级菜单-->
				<ul class="sub_menu">
					<li><a href="#">男士夏装</a>
						<ul>
							<li><a href="#">裤子</a></li>
							<li><a href="#">休闲裤</a></li>
							<li><a href="#">卡其裤</a></li>
							<li><a href="#">牛仔裤</a></li>
							<li><a href="#">风衣 & 运动夹克</a></li>
						</ul>
					</li>
				</ul> <!--二级菜单结束--></li>
			<li><a href="#">儿童</a></li>
			<li><a href="#">时尚</a></li>
			<li><a href="#">装饰品 </a>
				<ul class="sub_menu">
					<li><a href="#">装饰品 </a>
						<ul>
							<li><a href="#"> 太阳镜</a></li>
							<li><a href="#">围巾 </a></li>
							<li><a href="#">发饰品 </a></li>
							<li><a href="#">帽子和手套 </a></li>
							<li><a href="#">生活时尚 </a></li>
							<li><a href="#">牛仔系列 </a></li>
							<li><a href="#">风衣 & 西服</a></li>
						</ul>
					</li>
				</ul>
			</li>
		</ul>
	</div>
</div>
<!-- 导航 栏结束 -->