<%@ page import="org.example.edumanage.bean.Cours" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 24/02/2025
  Time: 09:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
    <title>Title</title>
</head>
<body>
<h1>Courses Assigned to Student</h1>
<table class="table table-bordered table-striped">
    <thead class="thead-dark">
    <tr>
        <th>ID</th>
        <th>NOM de cours</th>
        <th>Description</th>

    </tr>
    </thead>
    <tbody>
    <%
        List<Cours> coursList = (List<Cours>) request.getAttribute("courslist");

        for (Cours cours : coursList) {
    %>
    <tr>
        <td><%= cours.getIdcours() %></td>
        <td><%= cours.getCoursname() %></td>
        <td><%= cours.getDescription()%></td>


    </tr>
    <%

        }
    %>
    </tbody>
</table>

</body>
</html>
