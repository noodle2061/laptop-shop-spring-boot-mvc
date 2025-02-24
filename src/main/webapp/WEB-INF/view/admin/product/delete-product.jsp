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
            <title>Delete Product</title>
            <link href="/css/style.css" rel="stylesheet" />
            <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        </head>

        <body class="sb-nav-fixed">
            <jsp:include page="../layout/header.jsp" />
            <div id="layoutSidenav">
                <jsp:include page="../layout/sidebar.jsp" />
                <div id="layoutSidenav_content">
                    <div class="container mt-5 col-md-6 col-12 mx-auto">
                        <h1 class="text-center">Delete product</h1>
                        <hr>
                        <div class="alert alert-danger">
                            <p>Are you sure you want to delete this product with id = ${id}?</p>
                        </div>
                        <div class="d-flex gap-2 mt-3">
                            <a href="/admin/product" class="btn btn-success">Back</a>
                            <form:form action="/admin/product/delete" method="post">
                                <input type="text" name="id" value="${id}" hidden="true" />
                                <button class="btn btn-danger" type="submit">Submit</button>
                            </form:form>

                        </div>

                    </div>
                    <jsp:include page="../layout/footer.jsp" />
                </div>
            </div>
            <script src="/js/scripts.js"></script>

        </body>

        </html>