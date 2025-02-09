<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
<body>
    <div class="container mt-5 ">
        <div class="row col-md-6 col-12 mx-auto">
            <div>
                <h1>Create User</h1>
                <form action="/user/create" method="post" modelAttribute="newUser">
                    <form:lable path="username" class = "form-label">Username: </form:lable>
                    <form:input type="text" class = "form-control" path="username"/>
                </form>
            </div>
        </div>
    </div>
</body>
</html>