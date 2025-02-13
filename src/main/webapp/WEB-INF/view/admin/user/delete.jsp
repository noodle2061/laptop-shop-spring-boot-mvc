<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
<body>
    <div class="container mt-5 col-md-6 col-12 mx-auto">
        <h1 class="text-center">Delete user</h1>
        <hr>
        <div class="alert alert-danger">
            <p>Are you sure you want to delete this user?</p>
        </div>
        <a href="/admin/user" class="btn btn-success mt-3">Back</a>
        <form:form action="/admin/user/delete/${id}" method="post" class = "mt-3">
            <button class="btn btn-danger" type = "submit">Submit</button>
        </form:form>
    </div>
</body>
</html>