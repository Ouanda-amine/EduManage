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
        <h2 class="card-title text-center mb-4">Connect to your Account</h2>
        <form action="LoginServlet" method="post">
            <label for="username" class="form-label">User Name</label>
            <input type="text" class="form-control" id="username" name="username">
            <label for="password" class="form-label">PassWord</label>
            <input type="password" class="form-control" id="password" name="password">
            <button type="submit" class="btn btn-primary">Login</button>
        </form>
    </div>
</div>
</body>
</html>