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
        <h1 class="text-center">Edit user</h1>
        <hr>
        <form:form action="/admin/user/edit/${user.id}" method="post" modelAttribute="user" class = "mt-5">
            <form:label path="email" class = "form-label">Email</form:label>
            <form:input type="email" class = "form-control" path="email" disabled="true"/>

            <form:label path="fullname" class = "form-label mt-3">Fullname</form:label>
            <form:input type="text" class = "form-control" path="fullname"/>

            <form:label path="phone" class = "form-label mt-3">Phone</form:label>
            <form:input type="text" class = "form-control" path="phone"/>

            <form:label path="address" class = "form-label mt-3">Address</form:label>
            <form:input type="text" class = "form-control" path="address"/>

            <button class = "btn btn-warning mt-5" type = "submit">Update</button>
        </form:form>
    </div>
</body>
</html>