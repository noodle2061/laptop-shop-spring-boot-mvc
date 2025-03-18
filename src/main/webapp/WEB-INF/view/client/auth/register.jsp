<%@page contentType="text/html" pageEncoding="UTF-8" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="utf-8" />
                <meta http-equiv="X-UA-Compatible" content="IE=edge" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content="" />
                <meta name="author" content="" />
                <title>Register - Laptopshop</title>
                <link href="/css/style.css" rel="stylesheet" />
                <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
            </head>

            <body class="bg-primary">
                <div id="layoutAuthentication">
                    <div id="layoutAuthentication_content">
                        <main>
                            <div class="container">
                                <div class="row justify-content-center">
                                    <div class="col-lg-6">
                                        <div class="card shadow-lg border-0 rounded-lg mt-5">
                                            <div class="card-header">
                                                <h3 class="text-center font-weight-light my-4">Create Account</h3>
                                            </div>
                                            <div class="card-body">
                                                <form:form method="post" action="/register"
                                                    modelAttribute="registerUser" class="row">
                                                    <div class="col-md-6 col-12 mx-auto">
                                                        <form:label class="form-label" path="firstName">First Name</form:label>
                                                        <form:input path="firstName" type="text" class="form-control" cssErrorClass="form-control is-invalid" />
                                                        <form:errors class="invalid-feedback" path="firstName"/>
                                                    </div>

                                                    <div class="col-md-6 col-12 mx-auto">
                                                        <form:label class="form-label" path="lastName">Last Name</form:label>
                                                        <form:input path="lastName" type="text" class="form-control" cssErrorClass="form-control is-invalid" />
                                                        <form:errors class="invalid-feedback" path="lastName"/>
                                                    </div>

                                                    <div class="col-12 mx-auto">
                                                        <form:label class="form-label" path="email">Email</form:label>
                                                        <form:input path="email" type="text" class="form-control" cssErrorClass="form-control is-invalid" />
                                                        <form:errors class="invalid-feedback" path="email"/>
                                                    </div>

                                                    <div class="col-md-6 col-12 mx-auto">
                                                        <form:label class="form-label" path="password">Password</form:label>
                                                        <form:input path="password" type="password" class="form-control" cssErrorClass="form-control is-invalid" />
                                                        <form:errors class="invalid-feedback" path="password"/>
                                                    </div>

                                                    <div class="col-md-6 col-12 mx-auto">
                                                        <form:label class="form-label" path="confirmPassword">Confirm Password</form:label>
                                                        <form:input path="confirmPassword" type="password" class="form-control" cssErrorClass="form-control is-invalid" />
                                                        <form:errors class="invalid-feedback" path="confirmPassword"/>
                                                    </div>
                                                    
                                                    </div>
                                                    <div class="mt-4 mb-2">
                                                        <div class="d-grid col-6 mx-auto">
                                                            <button class="btn btn-primary btn-block" type="submit">
                                                                Create Account
                                                            </button>
                                                        </div>
                                                    </div>
                                                </form:form>
                                            
                                            <div class="card-footer text-center py-3">
                                                <div class="small"><a href="/login">Have an account? Go to login</a>
                                                </div>
                                            </div>
                                        </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </main>
                    </div>

                </div>
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"
                    crossorigin="anonymous"></script>
                <script src="/js/scripts.js"></script>
            </body>

            </html>