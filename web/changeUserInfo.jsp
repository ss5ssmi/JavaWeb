<%--
  Created by IntelliJ IDEA.
  User: Xing
  Date: 2017/6/13
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="ChangeUserInfoServlet" method="post">
    工号：<input name="no" value="<%=session.getAttribute("no") %>" hidden="hidden"><%=session.getAttribute("no") %><br>
    姓名：<input name="name" value="<%=session.getAttribute("name") %>" disabled="flase"><br>
    身份：<input name="type" value="<%=session.getAttribute("type") %>" disabled="flase"><br>
    性别：<input name="sex" value="<%=session.getAttribute("sex") %>" disabled="flase"><br>
    年龄：<input name="age" value="<%=session.getAttribute("age") %>"><br>
    电话：<input name="phone" value="<%=session.getAttribute("phone") %>"><br>
    地址：<input name="add" value="<%=session.getAttribute("add") %>"><br>
    <input type="submit" value="更新" >
</form>
</body>
</html>
