<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>
<h1>Struts2的复杂类型的数据封装</h1>
<h3>封装到List集合中：批量插入商品</h3>
<form action="${ pageContext.request.contextPath }/productAction1.action" method="post">
    商品名称:<input type="text" name="products[0].name"><br/>
    商品价格:<input type="text" name="products[0].price"><br/>
    商品名称:<input type="text" name="products[1].name"><br/>
    商品价格:<input type="text" name="products[1].price"><br/>
    商品名称:<input type="text" name="products[2].name"><br/>
    商品价格:<input type="text" name="products[2].price"><br/>
    <input type="submit" value="提交">
</form>
<h3>封装到Map集合中：批量插入商品</h3>
<form action="${ pageContext.request.contextPath }/productAction2.action" method="post">
    商品名称:<input type="text" name="map['one'].name"><br/>
    商品价格:<input type="text" name="map['one'].price"><br/>
    商品名称:<input type="text" name="map['two'].name"><br/>
    商品价格:<input type="text" name="map['two'].price"><br/>
    商品名称:<input type="text" name="map['three'].name"><br/>
    商品价格:<input type="text" name="map['three'].price"><br/>
    <input type="submit" value="提交">
</form>
</body>
</html>