<%@ page import="com.hand.Entity.Film" %>
<%@ page import="java.util.List" %>
<%--
  Created by IntelliJ IDEA.
  User: LiuSijia
  Date: 2017/8/12
  Time: 13:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
</head>
<body>
<form action="/UpdateServlet" method="post" name="loginForm">
    <table align="center" width="650" border="1" height="180"
           bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
        <tr bgcolor="white">
            <td align="center" colspan="8">
                <h2>修改电影信息</h2>
            </td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1">
            <td><b>ID</b></td>
            <td><b>Title</b></td>
            <td><b>Description</b></td>
            <td><b>Language</b></td>
        </tr>
        <%
            // 获取电影信息集合
            List<Film> list = (List<Film>) request.getAttribute("oneList");
            // 判断集合是否有效
            if (list == null || list.size() < 1) {
                out.print("没有数据！");
            } else {
                // 遍历用户集合中的数据
                for (Film film : list) {
        %>
        <tr align="center" bgcolor="#e1ffc1">
            <td>
                <input type="text" name="id" value="<%=film.getFilm_id()%>">
            </td>
            <td>
                <input type="text" name="title" value="<%=film.getTitle()%>">
            </td>
            <td>
                <input type="text" name="desc" style="width:700px" value="<%=film.getDescription()%>">
            </td>
            <%--<td>--%>
                <%--<input type="text" name="language" value="<%=film.getLanguage()%>">--%>
                <%----%>
            <%--</td>--%>
            <td>
                <select name="language">
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
        <%
                }
            }
        %>
    </table>
</form>
</body>
</html>