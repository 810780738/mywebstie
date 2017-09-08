<!DOCTYPE html>
<html>	
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="/css/login.css" rel='stylesheet' type='text/css' />
<script src="/js/jquery-2.1.0.js"></script>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
 <h1>欢饮登录小明论坛</h1>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
	<div class="avtar"><img src="images/avtar.png" /></div>
			<form>
				<input type="text" class="text" placeholder="请输入用户名">
				<input type="password" placeholder="请输入密码">
			</form>
			<div>
				<a href="" style="text-align: left;color:white;">忘记密码?</a><a href="/register" style="text-align: right;color:white;">注册?</a>
			</div>
	<div class="signin">
		<input type="submit" value="Login" >
	</div>
</div>
</body>
</html>