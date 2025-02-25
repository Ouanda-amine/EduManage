<%@ page import="org.example.edumanage.bean.Cours" %>
<%@ page import="java.util.List" %>
<%@ page import="org.example.edumanage.bean.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Assigner</title>
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<%
    Student student = (Student) request.getAttribute("student");
%>
<form action="affectationServlet" method="post">
    <input type="hidden" name="studdiid" value="<%= student.getId() %>">
    <input type="hidden" name="act" value="affectation">


    <div class="form-group">
        <label for="select">Cours :</label>
        <select name="select" class="form-control" id="select">
            <%
                List<Cours> coursList = (List<Cours>) request.getAttribute("courslist");

                for (Cours cours : coursList) {
            %>
            <option value="<%= cours.getIdcours() %>"><%= cours.getCoursname() %></option>
            <%
                }
            %>
        </select>
    </div>
    <button type="submit" class="btn btn-primary">Assigner</button>
</form>
</body>
</html>
