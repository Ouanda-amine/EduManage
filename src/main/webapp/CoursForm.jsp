
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Cours Form</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
            crossorigin="anonymous"
    />
</head>
<body>
<div class="container mt-5">
    <h1 class="text-center mb-4">Cours Form</h1>

    <form action="CoursServlet" method="post">
        <div class="form-group mb-3">
            <label for="nom" class="form-label">Nom de cours</label>
            <input
                    type="text"
                    class="form-control"
                    id="nom"
                    placeholder="Enter the name"
                    name="nomcours"
            />
        </div>
        <div class="form-group mb-3">
            <label for="description" class="form-label">description</label>
            <input
                    type="text"
                    class="form-control"
                    id="description"
                    placeholder="Enter the description"
                    name="description"
            />
        </div>



        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<script
        src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-..."
        crossorigin="anonymous"
></script>
</body>
</html>
