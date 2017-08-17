<%@ page import="java.util.List" %>
<%@ page import="com.hand.Entity.Film" %><%--
  Created by IntelliJ IDEA.
  User: LiuSijia
  Date: 2017/8/12
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新增电影</title>
</head>
<body>
<form action="/AddServlet" method="post" name="loginForm">
    <table align="center" width="650" border="1" height="180"
           bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
        <tr bgcolor="white">
            <td align="center" colspan="8">
                <h2>新增电影信息</h2>
            </td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1">
            <td><b>Title</b></td>
            <td><b>Description</b></td>
            <td><b>Language</b></td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1">
            <td><input type="text" name="title"></td>
            <td><input type="text" name="desc"></td>
            <td>

                <select name="language">
                    <%--<%--%>
                        <%--List<Film> list = (List<Film>) request.getAttribute("lanList");--%>
                        <%--for (Film film : list) {--%>
                    <%--%>--%>
                    <%--<option value="<%=film.getFilm_id()%>"><%=film.getLanguage()%></option>--%>
                    <%--<%--%>
                        <%--}--%>
                    <%--%>--%>
                        <option value="1">English</option>
                    <option value="2">Italian</option>
                    <option value="3">Japanese</option>
                    <option value="4">Mandarin</option>
                    <option value="5">French</option>
                    <option value="6">German</option>
                </select>

            </td>
        </tr>
        <tr>
            <td bgcolor="white" colspan="6" align="center">
                <input type="submit" value="提交">
            </td>
        </tr>
    </table>
</form>
</body>
</html>

