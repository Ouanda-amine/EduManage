<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>EduManagement</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous" />
</head>
<body class="bg-light">


<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container">
    <a class="navbar-brand" href="#"> Edu-Management </a>
    <form action="logout" > <button  class="btn btn-danger">logout</button> </form>
  </div>
</nav>


<div class="container mt-5">
  <div class="text-center mb-4">
    <h1 class="fw-bold">Welcome to Edu-Management</h1>
    <h2 class="text-muted">Pour une bonne gestion des étudiants et des cours</h2>
  </div>


  <div class="row justify-content-center">
    <div class="col-md-5">
      <div class="card shadow-sm">
        <div class="card-body text-center">
          <h2 class="card-title">Student Area</h2>
          <button class="btn btn-primary mt-3"   onclick="window.location.href='StudentForm.jsp'">Ajouter un étudiant</button>
        </div>
      </div>
    </div>

    <div class="col-md-5">
      <div class="card shadow-sm">
        <div class="card-body text-center">
          <h2 class="card-title">Course Area</h2>
          <button class="btn btn-primary mt-3" onclick="window.location.href='CoursForm.jsp'">Ajouter un cours</button>
        </div>
      </div>
    </div>
  </div>
</div>



</body>
</html>
