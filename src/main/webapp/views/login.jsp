<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Đăng nhập</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <div class="row justify-content-center">
        <div class="col-md-4">
            <div class="card shadow">
                <div class="card-body">
                    <h3 class="card-title text-center">Đăng nhập</h3>

                    <c:if test="${alert != null}">
                        <div class="alert alert-danger">${alert}</div>
                    </c:if>

                    <form action="${pageContext.request.contextPath}/login" method="post">
                        <div class="mb-3">
                            <label class="form-label">Tên đăng nhập</label>
                            <input type="text" name="username" class="form-control" required/>
                        </div>

                        <div class="mb-3">
                            <label class="form-label">Mật khẩu</label>
                            <input type="password" name="password" class="form-control" required/>
                        </div>

                        <button type="submit" class="btn btn-primary w-100">Đăng nhập</button>
                    </form>

                    <div class="text-center mt-3">
                        <p>Chưa có tài khoản?
                            <a href="${pageContext.request.contextPath}/register">Đăng ký</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
