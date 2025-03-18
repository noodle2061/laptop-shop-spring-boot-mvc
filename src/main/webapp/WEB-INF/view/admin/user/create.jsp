<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="vi">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="Hỏi Dân IT - Dự án laptopshop" />
                <meta name="author" content="Hỏi Dân IT" />
                <title>Dashboard - Hỏi Dân IT</title>
                <link href="/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>

                <script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
                <script>
                    $(document).ready(function () {
                        $("#avatarFile").change(function (event) {
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
                                <h1>Create User</h1>
                                <hr>
                                <form:form action="/admin/user/create" method="post" modelAttribute="newUser"
                                    class="mt-5 row" enctype="multipart/form-data">
                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="email" class="form-label">Email</form:label>
                                        <form:input type="text" class="form-control" path="email"
                                            cssErrorClass="form-control is-invalid" />
                                        <form:errors cssClass="invalid-feedback" path="email" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <label class="form-label" for="password">Password:</label>
                                        <form:input type="password" class="form-control"
                                            cssErrorClass="form-control is-invalid" path="password" />
                                        <form:errors cssClass="invalid-feedback" path="password" />
                                    </div>
                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="fullname" class="form-label">Fullname</form:label>
                                        <form:input type="text" class="form-control"
                                            cssErrorClass="form-control is-invalid" id="fullname" path="fullname" />
                                        <form:errors cssClass="invalid-feedback" path="fullname" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="phone" class="form-label">Phone</form:label>
                                        <form:input type="tel" class="form-control" id="phone" path="phone" />
                                    </div>
                                    <div class="mb-3">
                                        <form:label path="address" class="form-label">Address</form:label>
                                        <form:input type="text" class="form-control" id="address" path="address" />
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <form:label path="role.name" class="form-label">Role</form:label>
                                        <form:select path="role.name" class="form-select">
                                            <option value="USER">User</option>
                                            <option value="ADMIN">Admin</option>
                                        </form:select>
                                    </div>

                                    <div class="mb-3 col-md-6 col-12">
                                        <label for="avatarFile" class="form-label">Avatar: </label>
                                        <input type="file" class="form-control" id="avatarFile" name="avatarFile"
                                            accept=".jpg, .png, .jpeg" />
                                    </div>

                                    <div>
                                        <img id="avatarPreview"
                                            style="display: none; max-width: 250px; max-height: 250px;" class="mb-3" />
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