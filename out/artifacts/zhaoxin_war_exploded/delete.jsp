<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2017/10/4
  Time: 7:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath }/servlet/Servlet4" method="post">
输入你要删除的id
    <input type="text" name="id" />
    <input type="submit" value="删除"/>
</form>
</body>
</html>
