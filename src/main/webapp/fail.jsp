<%--
  Created by IntelliJ IDEA.
  User: LiuSijia
  Date: 2017/8/11
  Time: 11:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
    <style type="text/css">
        body{
            color: black;
            font-size: 24px;
            margin: 20px auto;
        }
        #message{
            text-align: center;
        }
    </style>
</head>
<body>
<div id="message">
    登录失败</br>
    用户名：<%= request.getParameter("uname")%><br>
    密码：<%= request.getParameter("upwd")%><br>
    <a href="login.jsp">返回登录页面</a>
</div>
</body>
</html>
