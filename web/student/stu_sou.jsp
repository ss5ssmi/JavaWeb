<%--
  Created by IntelliJ IDEA.
  User: Xing
  Date: 2017/6/13
  Time: 19:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" isELIgnored="false"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
</head>
<style type="text/css">
    table.gridtable {
        font-family: verdana,arial,sans-serif;
        font-size:11px;
        color:#333333;
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
<table>
    <form>
        <table class="gridtable">
            <tr>
                <td>ID</td>
                <td>学号</td>
                <td>数学</td>
                <td>英语</td>
                <td>C语言</td>
                <td>Java</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${sou}" var="a" >
                <tr>
                    <td>${a.id}</td>
                    <td>${a.No}</td>
                    <td>${a.math}</td>
                    <td>${a.english}</td>
                    <td>${a.c}</td>
                    <td>${a.java}</td>
                    <td></td>
                </tr>
            </c:forEach>
        </table>
    </form>
</table>
</body>
</html>
