<%@ page import="org.example.edumanage.bean.Student" %><%--
  Created by IntelliJ IDEA.
  User: amine
  Date: 20/02/2025
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mise a jour Formulaire</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container mt-5">
    <h2 class="text-center mb-4">Update Student</h2>

    <%
        Student student = (Student) request.getAttribute("student");
    %>

    <form action="StudentServlet" method="post">
        <input type="hidden" name="id" value="<%= student.getId() %>"/>
        <input type="hidden" name="action" value="update"/>

        <div class="form-group">
            <input type="text" class="form-control" name="nom" value="<%=student.getName() %>" required />
        </div>

        <div class="form-group">
            <input type="text" class="form-control" name="prenom" value="<%=student.getPrenom() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="email" value="<%=student.getEmail() %>" required />
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="datenaissance" value="<%=student.getDateNaissance()%>" required />
        </div>

        <button type="submit" class="btn btn-primary btn-block">Update</button>
    </form>


    <br>
    <a href="CoursServlet" class="btn btn-secondary"> <- list </a>
</div>

</body>
</html>
