<%--
  Created by IntelliJ IDEA.
  User: zx
  Date: 2017/10/3
  Time: 19:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/servlet/Servlet3" method="post">
    id : <input type="text" name="id" >
    用户名：<input type="text" name="username" value="${User.username}"/><br/>
    密码：<input type="password" name="password"/><br/>
    确认密码：<input type="password" name="repassword"/><br/>
    邮箱：<input type="text" name="email"/><br/>
    生日：<input type="text" name="birthday"/><br/>
    <input type="submit" value="提交"/><br/>
</form>
</body>
</html>
