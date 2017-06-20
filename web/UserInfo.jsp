<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<form>
    工号：<%=session.getAttribute("no") %><br>
    姓名：<%=session.getAttribute("name") %><br>
    身份：<%=session.getAttribute("type") %><br>
    性别：<%=session.getAttribute("sex") %><br>
    年龄：<%=session.getAttribute("age") %><br>
    电话：<%=session.getAttribute("phone") %><br>
    地址：<%=session.getAttribute("add") %><br>
    <a href="changeUserInfo.jsp"><input type="button" value="修改"></a>
</form>
</body>
</html>