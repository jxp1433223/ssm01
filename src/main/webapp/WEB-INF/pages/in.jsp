<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/7 0007
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="addUser.do">添加</a>
<table>
    <thead>
    <tr>
        <th>用户编号</th>
        <th>用户名</th>
        <th>密码</th>
        <th>电话号码</th>
        <th>操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="u">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
            <td>${u.tele}</td>
            <td><a href="deleteUser.do?id=${u.id}">删除</a>&nbsp;|&nbsp;<a href="updateUser.do?id=${u.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
