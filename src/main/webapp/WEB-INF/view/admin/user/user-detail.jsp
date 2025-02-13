<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>${user.fullname}</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    </head>
<body>
    <div class="container mt-5">
        <h1 class="text-center">Detail of ${user.fullname}</h1>
        <hr>
        <div class = "card col-md-8 mx-auto">
            <div class = "card-header" style="font-weight: bolder; text-align: center; background-color: rgb(160, 206, 168);">${user.fullname}'s Information</div>
            <div class = "card-body text-center">
                <div class="" style="width: 100%;">
                    <div class="">
                        <p><strong>Id: </strong>${user.id}</p>
                        <p><strong>Fullname:</strong> ${user.fullname}</p>
                        <p><strong>Email:</strong> ${user.email}</p>
                        <p><strong>Phone:</strong> ${user.phone}</p>
                        <p><strong>Address:</strong> ${user.address}</p>
                    </div>
                </div>
            </div>
        </div>
        <div class = "text-center mt-3">
            <a href="/admin/user" class = "btn btn-success">Back</a>
        </div>
    </div>
    
</body>
</html>