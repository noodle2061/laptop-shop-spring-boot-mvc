<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <meta name="description" content="Hỏi Dân IT - Dự án laptopshop"/>
    <meta name="author" content="Hỏi Dân IT"/>
    <title>Products Management</title>
    <link href="/css/style.css" rel="stylesheet"/>
    <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
</head>

<body class="sb-nav-fixed">
<jsp:include page="../layout/header.jsp"/>
<div id="layoutSidenav">
    <jsp:include page="../layout/sidebar.jsp"/>
    <div id="layoutSidenav_content">
        <h1>${product.image}</h1>
        <div class="mt-5 col-md-10 col-12 mx-auto">
            <div class="d-flex justify-content-between">
                <h3>List Product</h3>
                <a href="/admin/product/create" class="btn btn-primary">Create</a>
            </div>
            <hr>

            <table class="table table-bordered table-hover">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Sold</th>
                    <th>Image</th>
                    <th>Factory</th>
                    <th>Target</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="product" items="${products}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td><fmt:formatNumber value="${product.price}" type="number" groupingUsed="true"/></td>
                        <td>${product.quantity}</td>
                        <td>${product.sold}</td>
                        <td><img src="/images/product/${product.image}" alt="${product.name}" width="80" height="80">
                        </td>
                        <td>${product.factory}</td>
                        <td>${product.target}</td>
                        <td>
                            <a class="btn btn-primary" href="/admin/product/detail?id=${product.id}">View</a>
                            <a class="btn btn-warning" href="/admin/product/update?id=${product.id}">Edit</a>
                            <a class="btn btn-danger" href="/admin/product/delete?id=${product.id}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
        <jsp:include page="../layout/footer.jsp"/>
    </div>
</div>
<script src="/js/scripts.js"></script>

</body>

</html>