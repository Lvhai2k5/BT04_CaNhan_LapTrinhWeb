<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng ký</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-5">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="card-title text-center">Đăng ký</h3>

                    <c:if test="${alert != null}">
                        <div class="alert alert-danger">${alert}</div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/register" method="post">
                        <div class="mb-3">
                            <label class="form-label">Họ tên</label>
                            <input type="text" name="fullname" class="form-control" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Tên đăng nhập</label>
                            <input type="text" name="username" class="form-control" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="password" name="password" class="form-control" required/>
                        </div>

                        <button type="submit" class="btn btn-success w-100">Đăng ký</button>
                    </form>

                    <div class="text-center mt-3">
                        <p>Đã có tài khoản?
                            <a href="${pageContext.request.contextPath}/login">Đăng nhập</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
