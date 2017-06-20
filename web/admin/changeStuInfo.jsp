<%--
  Created by IntelliJ IDEA.
  User: Xing
  Date: 2017/6/14
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ChangeUserInfoServlet" method="post">
    学号：<input name="no" value="${requestScope.no}" hidden="hidden">${requestScope.no}<br>
    姓名：<input name="name" value="${requestScope.name}" disabled="flase"><br>
    身份：<input name="type" value="${requestScope.type}" disabled="flase"><br>
    性别：<input name="sex" value="${requestScope.sex}" disabled="flase"><br>
    年龄：<input name="age" value="${requestScope.age}"><br>
    电话：<input name="phone" value="${requestScope.phone}"><br>
    地址：<input name="add" value="${requestScope.add}"><br>
    <input type="submit" value="更新" >
</form>
</body>
</html>
