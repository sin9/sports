
<!DOCTYPE html>
<html lang="zh">
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>高校体育器材管理系统登录</title>
	<link rel="stylesheet" type="text/css" href="css/normalize.css" />
	<link rel="stylesheet" type="text/css" href="css/htmleaf-demo.css">
	<link rel="stylesheet" href="css/style.css" />
	<!--[if IE]>
		<script src="http://libs.useso.com/js/html5shiv/3.7/html5shiv.min.js"></script>
	<![endif]-->
</head>
<body>
	
		<div style="display: inline-block;width: 50%;line-height: 500px;">
		
			<h1 style="text-align: center;;">高校体育器材管理系统</h1>
			</div>
			<div class="htmleaf-container" style="display: inline-block;float: right;width: 45%;padding-top: 100px;">
		<div id="wrapper" class="login-page" >
		
		  <div id="login_form" class="form">
		  
		    <form class="login-form" action="/login" method="post">
		      <input type="text" placeholder="用户名" id="user_name" name="username"/>
		      <input type="password" placeholder="密码" id="password" name="password" />
		      <button id="login">登　录</button>
		      <p class="message"> <#if Request.error?exists><span class="error" style="color:#761C19;font-weight:bold;margin-left:30px;">${error}</span></#if> <a href="#">帮助</a></p>
		    </form>
		  </div>
		</div>

		
	</div>
	
	<script type="text/javascript" src="js/jquery-3.1.0.js" ></script>
	
	
</body>
</html>