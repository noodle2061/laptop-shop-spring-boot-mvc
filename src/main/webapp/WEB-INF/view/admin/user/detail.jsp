<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="/js/scripts.js"></script>

        </body>

        </html>