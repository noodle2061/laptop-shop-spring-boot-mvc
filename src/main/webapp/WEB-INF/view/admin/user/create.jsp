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
    <div class="container mt-5 ">
        <div class="row col-md-6 col-12 mx-auto">
            <div>
                <h1>Create User</h1>
                <form:form action="/admin/user/create" method="post" modelAttribute="newUser">
                    <div class="mb-3">
                        <form:label path="email" class="form-label">Email</form:label>
                        <form:input type="text" class="form-control" path="email"/>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="password">Password:</label>
                        <form:input type="password" class="form-control" path="password" />
                    </div>
                    <div class="mb-3">
                        <form:label path="fullname" class="form-label">Fullname</form:label>
                        <form:input type="text" class="form-control" id="fullname" path="fullname"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="phone" class="form-label">Phone</form:label>
                        <form:input type="tel" class="form-control" id="phone" path="phone"/>
                    </div>
                    <div class="mb-3">
                        <form:label path="address" class="form-label">Address</form:label>
                        <form:input type="text" class="form-control" id="address" path="address"/>
                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                </form:form>
            </div>
        </div>
    </div>
</body>
</html>