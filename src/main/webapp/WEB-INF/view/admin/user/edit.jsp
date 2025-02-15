<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
    <meta name="author" content="Hỏi Dân IT" />
    <title>Dashboard - Hỏi Dân IT</title>
    <link href="/css/style.css" rel="stylesheet" />
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
    <jsp:include page="../layout/header.jsp" />
    <div id="layoutSidenav">
        <jsp:include page="../layout/sidebar.jsp" />

        <div id="layoutSidenav_content">
            <div class="container mt-5 col-md-6 col-12 mx-auto">
                <h1 class="text-center">Edit user</h1>
                <hr>
                <form:form action="/admin/user/edit/${user.id}" method="post" modelAttribute="user" class="mt-5">
                    <div class="mb-3">
                        <form:label path="email" class="form-label">Email</form:label>
                        <form:input type="email" class="form-control" path="email" disabled="true" />
                    </div>

                    <div class="mb-3">
                        <form:label path="fullname" class="form-label">Fullname</form:label>
                        <form:input type="text" class="form-control" path="fullname" />
                    </div>

                    <div class="mb-3">
                        <form:label path="phone" class="form-label">Phone</form:label>
                        <form:input type="text" class="form-control" path="phone" />
                    </div>

                    <div class="mb-3">
                        <form:label path="address" class="form-label">Address</form:label>
                        <form:input type="text" class="form-control" path="address" />
                    </div>

                    <button class="btn btn-warning mt-3" type="submit">Update</button>
                </form:form>
            </div>
            <jsp:include page="../layout/footer.jsp" />
        </div>
    </div>
    <script src="/js/scripts.js"></script>
</body>

</html>
