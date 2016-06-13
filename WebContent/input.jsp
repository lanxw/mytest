<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>传参的方式</title>
</head>
<body>
<fieldset>
	<legend>用户注册</legend>
	<form action="/demo1">
		账号:<input name="userName" type="text">
		<br>
		密码:<input name="password" type="text">
		<br>
		<input type="submit" value="提交">
	</form>
</fieldset>

<fieldset>
	<legend>用户注册2</legend>
	<form action="/demo2" method="post">
		账号:<input name="userName" type="text">
		<br>
		密码:<input name="password" type="text">
		<br>
		<input type="submit" value="提交">
	</form>
</fieldset>


<fieldset>
	<legend>用户注册3</legend>
	<form action="/demo3" method="post">
		账号:<input name="userName1" type="text">
		<br>
		密码:<input name="password" type="text">
		<br>
		<input type="submit" value="提交">
	</form>
</fieldset>


<fieldset>
	<legend>用户注册4</legend>
	<form action="/demo4" method="post">
		账号:<input name="userName" type="text">
		<br>
		密码:<input name="password" type="text">
		<br>
		<input type="submit" value="提交">
	</form>
</fieldset>
</body>
</html>