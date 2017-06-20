<%--
  Created by IntelliJ IDEA.
  User: Xing
  Date: 2017/6/13
  Time: 18:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
  <meta name="renderer" content="webkit">
  <title>后台管理中心</title>
  <link rel="stylesheet" href="../web/css/pintuer.css">
  <link rel="stylesheet" href="../web/css/admin.css">
  <script src="../web/js/jquery.js"></script>
</head>
<%
  response.setHeader("Cache-Control","no-store");
  response.setHeader("Pragrma","no-cache");
  response.setDateHeader("Expires",0);
%>
<script>
    function getLangDate(){
        var dateObj = new Date(); //表示当前系统时间的Date对象
        var year = dateObj.getFullYear(); //当前系统时间的完整年份值
        var month = dateObj.getMonth()+1; //当前系统时间的月份值
        var date = dateObj.getDate(); //当前系统时间的月份中的日
        var hour = dateObj.getHours(); //当前系统时间的小时值
        var minute = dateObj.getMinutes(); //当前系统时间的分钟值
        if(month<10){
            month = "0"+month;
        }
        if(date<10){
            date = "0"+date;
        }
        if(hour<10){
            hour = "0"+hour;
        }
        if(minute<10){
            minute = "0"+minute;
        }
        var newDate = year+"年"+month+"月"+date+"日 "+hour+":"+minute;
        document.getElementById("dateStr").innerHTML = newDate;
        setTimeout("getLangDate()",1000);//每隔1秒重新调用一次该函数
    }
</script>

<body style="background-color:#f2f9fd;" onload="getLangDate()">
<div class="header bg-main">
  <div class="logo margin-big-left fadein-top">
    <h1><img src="../web/img/logo.png" class="rotate-hover" height="50" alt="" />后台管理中心</h1>
  </div>

  <div class="head-l">
    <img src="../web/img/user.png">你好，<a href="UserInfoServlet" target="right"><%=session.getAttribute("name") %></a>
      <a href="#" style="margin-left:30px; vertical-align: middle;"><img src="../web/img/mess.png">消息</a>
      <img src="../web/img/time.png" style="margin-left:25px; vertical-align: middle;"><span id="dateStr" style="margin-left:5px;"></span>
    <a href="LogoutServlet" style="margin-left:30px;"><img src="../web/img/logout.png">登出</a>
  </div>
</div>
<div class="leftnav">
  <div class="leftnav-title"><strong><span class="icon-list"></span>菜单列表</strong></div>
  <h2><span class="icon-user"></span>基本设置</h2>
  <ul style="display:block">
    <li><a href="../web/changepassword.jsp" target="right"><span class="icon-caret-right"></span>密码修改</a></li>
    <li><a href="UserInfoServlet" target="right"><span class="icon-caret-right"></span>个人资料</a></li>
  </ul>
  <h2><span class="icon-pencil-square-o"></span>成绩</h2>
  <ul>
    <li><a href="FondSourceServlet" target="right"><span class="icon-caret-right"></span>成绩查询</a></li>
  </ul>
</div>
<script type="text/javascript">
    $(function(){
        $(".leftnav h2").click(function(){
            $(this).next().slideToggle(200);
            $(this).toggleClass("on");
        })
        $(".leftnav ul li a").click(function(){
            $("#a_leader_txt").text($(this).text());
            $(".leftnav ul li a").removeClass("on");
            $(this).addClass("on");
        })
    });
</script>
<ul class="bread">
  <li><a href="../web/main.html" target="right" class="icon-home"> 首页</a></li>
  <li><span href="##" id="a_leader_txt">网站信息</span></li>
</ul>
<div class="admin">
  <iframe scrolling="auto" rameborder="0" src="../web/main.html" name="right" width="100%" height="100%"></iframe>
</div>
<div style="text-align:center;">
</div>
</body>
</html>