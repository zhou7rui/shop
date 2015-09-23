<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>注册</title>
    <%@ include file="/public/head.jspf" %>
    <!-- <link href="css/normalize.css" rel="stylesheet"/> -->
	<link href="css/jquery-ui.css" rel="stylesheet"/>
	<style type="text/css">
	.reg{
		width:890px;
		margin: 0 auto;
	}
	#progressbar {
		margin-bottom: 30px;
		overflow: hidden;
		counter-reset: step;
}
	#progressbar li{
		list-style: none;
		text-transform: uppercase;
		font-size: 14px;
		color:#999;
		width: 33.33%;
		float: left;
		position: relative;
	}
	#progressbar .active{
       color: #3e3e3e;
  	  border-bottom: 2px solid #ff4700;
	}
	#msform fieldset{
		border: 0 none;
		width:500px;
		margin: 0 auto;
		
	}
	#msform input{
	padding: 15px;
	border: 1px solid #ccc;
	border-radius: 3px;
	margin-bottom: 10px;
	width: 100%;
	box-sizing: border-box;
	font-family: montserrat;
	color: #2C3E50;
	font-size: 13px;
	}
	#msform #phone{
		width: 70%;
	}
	#msform #code{
		width: 30%;
	}

	#msform .action-button {
	width: 100px;
	background: #27AE60;
	font-weight: bold;
	color: white;
	border: 0 none;
	border-radius: 1px;
	cursor: pointer;
	padding: 10px 5px;
	margin: 10px 5px;
}
	#msform #fie-2{
		display: none;
	}
	#msform #fie-3{
		display: none;
	}
	</style>
  </head>
  <body>
    <div class="wrapper">
     <!-- 引入头部文件 -->
     <jsp:include page="/public/head.jsp"></jsp:include>
     <div class="reg">
       <form id="msform" action="" method="post">
       <ul id="progressbar">
		<li class="active">第一步:设置登录名</li>
		<li>第二步:用户信息</li>
		<li>第三步：注册成功</li>
	</ul>
	   <fieldset id="fie-1">
		<label>手机:</label><input type="text" name="phone" placeholder="手机" id="phone" />
		<input type="button" name="next" class="send action-button" value="获取验证码"> 
		<p style="display: none">
		<label>验证码:</label><input type="text" name="code"  placeholder="输入手机收的验证码" id="code" />
		</p>
		<button name="next" class="next action-button" id="next-1" >下一步</button>
	   </fieldset>
	   <fieldset id="fie-2">
			<label>用户名:</label><input type="text" name="login" placeholder="user name" />
		
			<label>昵称:</label><input type="text" name="name" placeholder="user name" />
		
			<label>密码:</label><input type="password" name="pwd" placeholder="Password" />
			
			<label>再次输入密码:</label><input type="password" name="cpwd" placeholder="Confirm Password" />
		
			<label>邮箱:</label><input type="email" name="email" placeholder="Email" />
			<input type="submit" name="next" class="next action-button" id="next-2" value="下一步" />
	   </fieldset>
	   <fieldset id="fie-3">
		<input type="text" name="phone" placeholder="手机" />
		<input type="button" name="previous" class="previous action-button" value="Previous" />
		<input type="button" name="next" class="next action-button" value="注册" />
	   </fieldset>
	   </form>
	</div>
	<script type="text/javascript" src="js/user/jquery-1.8.2.min.js"></script>
	<script type="text/javascript" src="js/user/jquery-ui.min.js"></script>
	<script type="text/javascript" src="js/user/jquery-validate.js"></script>
	<script type="text/javascript">
		$(function() {
			/************************验证 start*******************************/
			$("form").validate({
				debug:true,
				rules:{
					phone:{
						required:true					
					},
					login:{
						required:true
					},
					name:{
						required:true
					},
					pwd:{
						required:true,
						rangelength:[6,12]
					},
					cpwd:{
						equalTo:'#pass'
					},
					email:{
						email:true
					}
					
				 }
				});
			
	
		
		/****************************验证 end***************************/
		
			//短信发送
			$(".send").click(function() {
		    var step = 59;
            var _res = setInterval(function()
            {   
                $(".send").attr("disabled", true);//设置disabled属性
                $(".send").val("重新发送"+step);
                step-=1;
                if(step <= 0){
                $(".send").removeAttr("disabled"); //移除disabled属性
                $(".send").val("获取验证码");
                clearInterval(_res);//清除setInterval
                }
            },1000);	
				$("p").fadeIn();
				var phone = $("#phone").val();
				/* $.post('user_SMS', {
					phone : phone
				}); */
			});
			$("#next-1").click(function() {
			//	console.log("aa");
				var code = $("#code").val();
				$.post('user_iScode',{code:code},function(data){
					if(data=="true"){
						$("#next-1").parent().hide();    //隐藏当前
						$("#next-1").parent().next().fadeIn("slow");    // 显示下一步
						$("#progressbar li").eq($("fieldset").index($("#next-1").parent().next())).addClass("active"); //添加class属性
					}
				},"text");
				
			});
			
		});
	</script>
		
     <!-- 引入尾部文件 -->
     <jsp:include page="/public/tail.jsp"></jsp:include>
     </div>
  </body>
</html>
