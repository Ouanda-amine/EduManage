<%@ page import="org.example.edumanage.bean.Student" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Liste des etudiants</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">students List</h2>

    <table class="table table-bordered table-striped">
        <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>NOM</th>
            <th>PRENOM</th>
            <th>EMAIL</th>
            <th>Date de Naissance</th>
        </tr>
        </thead>
        <tbody>
        <%
            List<Student> studentlist = (List<Student>) request.getAttribute("studentlist");

            for (Student student : studentlist) {
        %>
        <tr>
            <td><%= student.getId() %></td>
            <td><%= student.getName() %></td>
            <td><%= student.getPrenom()%></td>
            <td><%= student.getEmail() %></td>
            <td><%= student.getDateNaissance() %></td>
            <td>
                <a href="modifieremployee?id=<%= student.getId() %>" class="btn btn-warning btn-sm">Edit</a>
                <form action="deleteEmployee" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= student.getId() %>" />
                    <input type="submit" value="Delete" class="btn btn-danger btn-sm" />
                </form>
            </td>
        </tr>
        <%

            }
        %>
        </tbody>
    </table>

    <a href="createmployee" class="btn btn-success">Add new Employee</a>
</div>

</body>
</html>
