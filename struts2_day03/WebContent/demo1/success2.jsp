<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>查看值栈的内部结构s</h1>
<s:debug></s:debug>


<!-- 获取对象的数据 -->
<s:property value="username"/>
<s:property value="password"/>
<!-- 获得集合中的数据 -->
<s:property value="list[0].username"/>
<s:property value="list[0].password"/><br/>
<s:property value="list[1].username"/>
<s:property value="list[1].password"/><br/>
<s:property value="list[2].username"/>
<s:property value="list[2].password"/><br/>

<!-- 获得context中的数据 -->
<s:property value="#request.name"/>
<s:property value="#session.name"/>
<s:property value="#application.name"/>
<s:property value="#attr.name"/>
<s:property value="#parameters.id"/>
</body>
</html>