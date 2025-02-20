<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 15/02/2025
  Time: 11:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EduManagement</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
</head>
<body class="bg-light" >

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="#">Edu-Management</a>
       </div>
</nav>

           <div class="container my-5">
                <div class="card-body">
                    <h2 class="card-title text-center mb-4">ajouter Etudiant</h2>
                   <form action="Student" method="post">
                       <div class="mb-3">
                           <label for="nom" class="form-label">Nom</label>
                           <input type="text" class="form-control" id="nom" name="nom">
                             </div>
                                  <div class="mb-3">
                                    <label for="prenom" class="form-label">Age</label>
                                      <input type="text" class="form-control" id="prenom" name="prenom">
                                  </div>
                                         <div class="mb-3">
                                             <label for="email" class="form-label">Email</label>
                                                 <input type="email" class="form-control" id="email" name="email">
                                        </div>
                       <div class="mb-3">
                           <label for="dateNaissance" class="form-label">Date de Naissance</label>
                           <input type="text" class="form-control" id="dateNaissance" name="dateNaissance">
                       </div>
                       <div class="mb-3">
                           <button type="submit" class="btn btn-primary" onclick="window.location.href='StudentList.jsp'">Ajouter</button>
                       </div>
                   </form>
                </div>
    </div>

</body>
</html>
