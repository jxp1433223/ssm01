<%--
  Created by IntelliJ IDEA.
  User: abd
  Date: 2019/1/7
  Time: 18:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        table{
            border: solid 1px #000000;
            border-collapse: collapse;
        }
        table thead tr th,table tbody tr td{
            border: solid 1px #000000;
            padding: 5px 10px;
        }
        table tbody tr:nth-child(odd){
            background-color: blanchedalmond;
        }
        #fyt{
            list-style: none;
        }
    </style>
</head>
<body>
<%--${lists}--%>
<p>显示内容界面</p>
<a href="addUser.do">添加</a>
<table>
    <form>
        <input type="text" name="username"><input type="submit" value="sousuo">
    </form>
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
    <c:forEach items="${lists}" var="list">
        <tr>
            <td>${list.id}</td>
            <td>${list.username}</td>
            <td>${list.password}</td>
            <td>${list.tele}</td>
            <td><a href="deleteUser.do?id=${list.id}">删除</a>&nbsp;|&nbsp;<a href="updateUser.do?id=${list.id}">修改</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<br>
<ul id="fyt">
<c:choose>
    <c:when test="${page.pages>0}">
        <c:choose>
            <c:when test="${page.isFirstPage}">
                <li>首页</li>
                <li>上一页</li>
            </c:when>
            <c:otherwise>
                <li><a href="list.do?pageNum=1${uname}">首页</a></li>
                <li><a href="list.do?pageNum=${page.prePage}${uname}">上一页</a></li>
            </c:otherwise>
        </c:choose>
        <c:forEach items="${page.navigatepageNums}" var="i">
            <c:choose>
                <c:when test="${page.pageNum==i}">
                    <li>${i}</li>
                </c:when>
                <c:otherwise>
                    <li><a href="list.do?pageNum=${i}${uname}">${i}</a> </li>
                </c:otherwise>
            </c:choose>

        </c:forEach>
         <c:choose>
            <c:when test="${page. isLastPage}">
                <li>下一页</li>
                <li>尾页</li>
            </c:when>
            <c:otherwise>
                <li><a href="list.do?pageNum=${page.nextPage}${uname}">下一页</a></li>
                <li><a href="list.do?pageNum=${page.pages}${uname}">尾页</a></li>
            </c:otherwise>
        </c:choose>
    </c:when>
</c:choose>
</body>
</html>
