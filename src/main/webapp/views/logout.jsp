<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Đăng xuất</title>
    <meta charset="UTF-8"/>
    <meta http-equiv="refresh" content="3;url=${pageContext.request.contextPath}/login"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5 text-center">
    <h2 class="text-success">Bạn đã đăng xuất thành công!</h2>
    <p>Bạn sẽ được chuyển về trang đăng nhập trong 3 giây...</p>
    <a class="btn btn-primary mt-3" href="${pageContext.request.contextPath}/login">Về trang đăng nhập ngay</a>
</div>
</body>
</html>
