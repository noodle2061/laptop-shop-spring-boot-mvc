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
    <div class="container mt-5">
        <div class = "col-md-12 mx-auto">
            <div class = "d-flex justify-content-between">
                <h3>Table users</h3>
                <a href = "/admin/user/create" class = "btn btn-primary">Create</a>
            </div>
            <hr>
            <table class = "table table-bordered table-hover">
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Email</th>
                        <th>Fullname</th>
                        <th>Phone</th>
                        <th>Address</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items = "${users}" var = "user">
                        <tr>
                            <td>${user.id}</td>
                            <td>${user.email}</td>
                            <td>${user.fullname}</td>
                            <td>${user.phone}</td>
                            <td>${user.address}</td>
                            <td>
                                <a href="/admin/user/${user.id}" class = "btn btn-success">View</a>
                                <a href = "/admin/user/edit/${user.id}" class = "btn btn-warning">Edit</a>
                                <a href = "/admin/user/delete/${user.id}" class = "btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</body>
</html>