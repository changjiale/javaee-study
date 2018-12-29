<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>查看值栈的内部结构s</h1> 
<s:debug></s:debug>
<!-- 方式一 利用action的值栈特性 -->
<%-- <s:property value="user.username"/>
<s:property value="user.password"/> --%>

<!-- 方式二  调用ValueStack本身的方法 -->
<s:property value="username"/>
<s:property value="password"/>

<s:property value="name"/>
</body>
</html>