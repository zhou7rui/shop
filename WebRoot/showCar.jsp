<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>购物车</title>
	<%@include file="/public/head.jspf"%>
	<script type="text/javascript">
		$(function(){
		    //更改数量
			$(".text").change(function(){
			 var number = this.value;
			 if(parseInt(number)==number && !isNaN(number) && number>0){
			   var productid = $(this).parents("tr:first").attr("title");
			   $.post('sorder_updatesorder.action',{id:productid,number:number},function(total){
						$("#total").html(total);
			   },"text");
			   var price = $(this).parent().prev().html()*number;
			   $(this).parent().next().html(price.toFixed(2));
			  }else{
			  	this.value = $(this).arrt("title");
			  }
			});
		   //删除
		   $(".remove").click(function(){
		   		 var tr = $(this).parents("tr:first");
		   		 var productid = tr.attr("title");
		   		 $.post('sorder_removeSorder.action',{id:productid},function(price){
		   		 	console.log($(this).parents("tr:first"));
		   		 	tr.html("");
		   		 	$("#total").html(price);
		   		 },"text");
		   		console.log("aa");
		   });
		   
		
		});
	</script>
<body>
	<div class="wrapper">
		<!-- 头部开始 -->
		<jsp:include page="/public/head.jsp" />
		<!-- 头部结束 -->
		<div class="section_container">
		
			<!-- 购物车 -->
			<div id="shopping_cart">
				<div class="message success">我的购物车</div>
				<table class="data-table cart-table" cellpadding="0" cellspacing="0">
					<tr>
						<th class="align_center" width="10%">商品编号</th>
						<th class="align_left" width="35%" colspan="2">商品名称</th>
						<th class="align_center" width="10%">销售价格</th>
						<th class="align_center" width="20%">数量</th>
						<th class="align_center" width="15%">小计</th>
						<th class="align_center" width="10%">删除</th>
					</tr>
					
					<c:forEach items="${sessionScope.forder.sorders}" var = "sorder">
					
					<tr title="${sorder.product.id}">
						<td class="align_center" ><a href="#" class="edit">${sorder.product.id}</a>
						</td>
						<td width="80px"><img src="images/cart1.jpg" width="80"
							height="80" />
						</td>
						<td class="align_left"><a class="pr_name" href="#">${sorder.name}</a>
						</td>
						<td class="align_center vline">${sorder.price}
						</td>
						<td class="align_center vline">
							<input class="text" style="height: 20px;" title="${sorder.number}" value="${sorder.number}">		
						</td>
						<td class="align_center vline"><span class="price">￥${sorder.price*sorder.number}</span>
						</td>
						<td class="align_center vline"><a href="javascript:void(0)" class="remove"></a>
						</td>
					</tr>
					</c:forEach>
				</table>
				</div>
				<!-- 结算 -->
				<div class="totals">
					<table id="totals-table">
						<tbody>
							<tr>
								<td width="60%" colspan="1" class="align_left">运费</td>
								<td class="align_right" style=""><span class="price">￥0.00</span>
								</td>
							</tr>
							<tr>
								<td width="60%" colspan="1" class="align_left total"><strong>总计</strong>
								</td>
								<td class="align_right" style=""><span class="total"><strong id="total">￥${sessionScope.forder.price}</strong>
								</span>
								</td>
							</tr>
						</tbody>
					</table>
					</div>
					<div class="action_buttonbar">
						<button type="button" title="" class="checkout fr"
							style="background-color: #f38256;">
							<font><font><a href="${shop}/user/confirm.jsp">确认订单</a></font>
							</font>
						</button>
						<button type="button" title="" class=" fr">
							<font><font>清空购物车</font>
							</font>
						</button>
						<button type="button" title="" class="continue fr">
							<font>
								<a href="${shop}/index.jsp">继续购物</a>
							</font>
							
						</button>
						<div style="clear:both"></div>
					</div>
				</div>
			<!-- 导航栏结束 -->
			<!-- 尾部引入 -->
			<jsp:include page="/public/tail.jsp"/>
	</div>
</body>
</html>
