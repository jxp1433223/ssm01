<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2019/1/7
  Time: 22:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<p>修改界面</p>
<form action="doUpdateUser.do" method="post">
    <input type="text" name="id" hidden="hidden" value="${user.id}">
    用户名称：<input type="text" name="username" value="${user.username}"><br>
    密码：<input type="text" name="password" value="${user.password}"><br>
    电话号码：<input type="text" name="tele" value="${user.tele}"><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
