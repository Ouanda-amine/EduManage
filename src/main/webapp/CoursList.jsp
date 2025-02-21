<%@ page import="org.example.edumanage.bean.Cours" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/02/2025
  Time: 11:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Cours List</h2>

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

            <td>
                <a href="CoursServlet?action=edit&idcours=<%= cours.getIdcours() %>" class="btn btn-warning btn-sm">Edit</a>
                <a href="CoursServlet?action=delete&idcours=<%= cours.getIdcours() %>" class="btn btn-danger btn-sm">Delete</a>



            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="CoursForm.jsp" class="btn btn-success">Add new cours</a>
</div>


</body>
</html>
