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
                <title>Create Product</title>
                <link href="/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
                <script>
                    $(document).ready(function () {
                        $("#productImage").change(function (event) {
                            var file = event.target.files[0]; // Lấy file người dùng chọn
                            if (file) {
                                var reader = new FileReader();
                                reader.onload = function (e) {
                                    $("#avatarPreview").attr("src", e.target.result).show(); // Hiển thị ảnh
                                };
                                reader.readAsDataURL(file); // Đọc file ảnh dưới dạng URL
                            } else {
                                $("#avatarPreview").hide(); // Ẩn ảnh nếu không có file
                            }
                        });
                    });
                </script>

            </head>

            <body class="sb-nav-fixed">
                <jsp:include page="../layout/header.jsp" />
                <div id="layoutSidenav">
                    <jsp:include page="../layout/sidebar.jsp" />
                    <div id="layoutSidenav_content">
                        <div class="row col-md-6 col-12 mx-auto">
                            <div>
                                <h1>Create Product</h1>
                                <hr>
                                <form:form action="/admin/product/create" method="post" modelAttribute="newProduct"
                                    class="mt-5 row" enctype="multipart/form-data">
                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="name" class="form-label">Name:</form:label>
                                        <form:input type="text" class="form-control" path="name" />
                                    </div>
                                    <div class="mb-3 col-md-6 col-12">
                                        <label class="form-label" for="password">Price:</label>
                                        <form:input type="text" class="form-control" path="price" />
                                    </div>
                                    
                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="detailDesc" class="form-label">DetailDesc:</form:label>
                                        <form:input type="text" class="form-control" path="detailDesc" />
                                    </div>
                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="shortDesc" class="form-label">ShortDesc:</form:label>
                                        <form:input type="text" class="form-control" path="shortDesc" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="quantity" class="form-label">Quantity:</form:label>
                                        <form:input type="text" class="form-control" path="quantity" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="sold" class="form-label">Sold:</form:label>
                                        <form:input type="text" class="form-control" path="sold" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="factory" class="form-label">Factory:</form:label>
                                        <form:input type="text" class="form-control" path="factory" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="target" class="form-label">Target:</form:label>
                                        <form:input type="text" class="form-control" path="target" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <label for="productImage" class="form-label">Image:</label>
                                        <input type="file" class="form-control" id="productImage" name="productImage" accept=".jpg, .png, .jpeg"/>
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <img id="avatarPreview" style="display: none; max-width: 250px; max-height: 250px;" class = "d-block mx-auto mb-3" />
                                    </div>

                                    <div>
                                        <button type="submit" class="btn btn-primary">Submit</button>
                                    </div>

                                </form:form>
                            </div>
                        </div>
                        <jsp:include page="../layout/footer.jsp" />
                    </div>
                </div>
                <script src="/js/scripts.js"></script>

            </body>

            </html>