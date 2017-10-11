<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<link rel="stylesheet" href="css/style.css" />
</head>
<body>
<div class="container">
	<div id="content">
		<form action="LoginServlet" method="post">
			<h1>欢迎登录</h1>
			<div>
				<input type="text" placeholder="用户名" required="" id="username" name="Accname" />
			</div>
			<div>
				<input type="password" placeholder="密码" required="" id="password" name="Accpassword"  />
			</div>
			<div style="font=align-content: flex-end;">
				<input type="checkbox" value="1" name="type" style="float: left;display: inline-block;" />
				<a style="float:left;display: inline-block;margin: auto 0;text-decoration: none;">记住密码</a>
			</div>
			<div>
				<input type="submit" value="登录" name="登录"/>
				<a href="#">注册</a>
			</div>
		</form>
		
	</div>
</div>
</body>
</html>