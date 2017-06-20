<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<script language="javascript" type="text/javascript">
    function check()
    {
        if (document.form1.password2.value==""){
            alert("请输入密码!");
            return false;
        }
        if (document.form1.password.value==""){
            alert("请确认密码!");
            return false;
        }
        if (document.form1.password.value!=document.form1.password2.value){
            alert("对不起!两次密码不同！");
            return false;
        }
        return true;
    }
</script>
<body>

<form name="form1" action="ChangePassServlet" method="post">
密&nbsp;&nbsp;&nbsp;&nbsp;码:<input type="password" name="password" ><br>
确认密码:<input type="password" name="password2" ><br>
<input type="submit" value="更改" onClick="return check()" >
</form>

</body>
</html>