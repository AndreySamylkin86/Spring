<%@ page import="ru.geekbrains.ru.geekbrains.persist.Product" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: macbook
  Date: 01.02.2021
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Users</title>
</head>
<body>

<table>
    <tr>
        <th>Id</th>
        <th>Username</th>
    </tr>
    <% for (User product : (List<User>) request.getAttribute("users")) { %>
    <tr>
        <td><%= product.getId() %></td>
        <td>
            <a href="<%= application.getContextPath() + "/product/" + product.getId() %>"><%= product.getUsername() %></a>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
