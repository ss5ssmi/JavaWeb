<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<style type="text/css">
    table.gridtable {
        font-family: verdana, arial, sans-serif;
        font-size: 11px;
        color: #333333;
        border-width: 1px;
        border-color: #666666;
        border-collapse: collapse;
        margin: 0 auto;
        width: 80%;
    }

    table.gridtable th {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #dedede;
    }

    table.gridtable td {
        border-width: 1px;
        padding: 8px;
        border-style: solid;
        border-color: #666666;
        background-color: #ffffff;
    }
</style>
<body>
<table class="gridtable">
    <tr>
        <td>ID</td>
        <td>No</td>
        <td>Name</td>
        <td>Sex</td>
        <td>Age</td>
        <td>Phone</td>
        <td>Address</td>
        <td>操作</td>
    </tr>
    <c:forEach items="${requestScope.stu}" var="a">
        <form action="StuInfoServlet?no=${a.No}&type=student" method="post">
            <tr>
                <td>${a.id}</td>
                <td><input id="no"  value="${a.No}" hidden="hidden">${a.No}</td>
                <td><input id="name" value="${a.Name}" hidden="hidden">${a.Name}</td>
                <td><input id="sex" value="${a.Sex}" hidden="hidden">${a.Sex}</td>
                <td><input id="age" value="${a.Age}" hidden="hidden" >${a.Age}</td>
                <td><input id="phone" value="${a.Phone}" hidden="hidden">${a.Phone}</td>
                <td><input  id="add" value="${a.Addr}" hidden="hidden">${a.Addr}</td>
                <td><input type="submit" value="编辑"><a href="DelUserServlet?no=${a.No}&type=stu" style="margin-left: 5px;"><input type="button" value="删除"></a></td>
            </tr>
        </form>
    </c:forEach>
</table>
</body>
</html>