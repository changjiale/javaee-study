<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Struts2的数据封装</h1>
<h3>方式一：属性驱动-提供set方法的方式</h3>

<form action="${ pageContext.request.contextPath }/userAction1.action" method="post">
	用户名:<input type="text" name="username"/><br/>
	密码:<input type="password" name="password"><br/>
	年龄:<input type="text" name="age"/><br/>
	生日:<input type="text" name="birthday"/><br/>
	工资:<input type="text" name="salary"/><br/>
	<input type="submit" value="提交">
</form>

</body>
</html>