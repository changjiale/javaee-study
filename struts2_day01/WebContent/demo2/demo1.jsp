<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Action的访问</h1>
<h3>通过method方式</h3>
<a href="${ pageContext.request.contextPath }/userFind.action">查询用户</a><br/>
<a href="${ pageContext.request.contextPath }/userUpdate.action">修改用户</a><br/>
<a href="${ pageContext.request.contextPath }/userDelete.action">删除用户</a><br/>
<a href="${ pageContext.request.contextPath }/userSave.action">保存用户</a><br/>

<h3>通过通配符的方式</h3>
<a href="${ pageContext.request.contextPath }/product_find.action">查询商品</a><br/>
<a href="${ pageContext.request.contextPath }/product_update.action">修改商品</a><br/>
<a href="${ pageContext.request.contextPath }/product_delete.action">删除商品</a><br/>
<a href="${ pageContext.request.contextPath }/product_save.action">保存商品</a><br/>

<h3>通过动态方法访问的方式</h3>
<a href="${ pageContext.request.contextPath }/customer!find.action">查询客户</a><br/>
<a href="${ pageContext.request.contextPath }/customer!update.action">修改客户</a><br/>
<a href="${ pageContext.request.contextPath }/customer!delete.action">删除客户</a><br/>
<a href="${ pageContext.request.contextPath }/customer!save.action">保存客户</a><br/>
</body>
</html>