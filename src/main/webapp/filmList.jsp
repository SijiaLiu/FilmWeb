<%@ page import="com.hand.Entity.Film" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: LiuSijia
  Date: 2017/8/15
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>电影列表</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/findAll" method="post" name="listForm">
    <% if (request.getAttribute("return_url") != null){%>
    <input type="hidden" name="return_url" value="<%= request.getAttribute("return_url")%>" />
    <%} %>
    <table align="center" width="1200" border="1" height="180"
           bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
        <tr bgcolor="white">
            <td align="center" colspan="9">
                <h2>Film Information</h2>
            </td>
        </tr>
        <tr align="center" bgcolor="#e1ffc1" style="height: 70px">
            <td><b>ID</b></td>
            <td><b>Title</b></td>
            <td><b>Description</b></td>
            <td><b>Language</b></td>
            <td><b>Update</b></td>
            <td><b>Del</b></td>
            <td><a href="FindLanServlet">Add</a></td>
        </tr>
        <%
            // 获取电影信息集合
            List<Film> list = (List<Film>) request.getAttribute("filmList");
            // 判断集合是否有效
            if (list == null || list.size() < 1) {
                out.print("没有数据！");
            } else {
                // 遍历用户集合中的数据
                for (Film film : list) {
        %>
        <tr align="center"  bgcolor="white" style="height: 70px">
            <td><%=film.getFilm_id()%></td>
            <td><%=film.getTitle()%></td>
            <td><%=film.getDescription()%></td>
            <td><%=film.getLanguage()%></td>
            <td >
                <a href="FindOneServlet?id=<%=film.getFilm_id()%>">++</a>
            </td>
            <td>
                <a href="DeleteServlet?id=<%=film.getFilm_id()%>">--</a>
            </td>
            <td></td>
        </tr>
        <%
                }
            }
        %>
    </table>
</form>
</body>
</html>
