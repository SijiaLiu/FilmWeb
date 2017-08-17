<%--
  Created by IntelliJ IDEA.
  User: LiuSijia
  Date: 2017/8/11
  Time: 11:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆成功页面</title>
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
    <h1>登录成功</h1></br>
    <a href="login.jsp">登录页面</a><br>
    <a href="index.jsp">主页</a><br>
    <a href="findAll">电影列表</a><br>
    <%
        String flag = "";
        Object obj = session.getAttribute("flag");
        if (obj != null){
            flag = obj.toString();
        }
        if (flag.equals("login_success")){
    %>
    <a href="<%= request.getContextPath() %>/LogoutServlet">退出</a>
    <%} else{ %>
    <a href="<%= request.getContextPath() %>/login1.jsp">登录</a>
    <%} %>
</div>
</body>
</html>
