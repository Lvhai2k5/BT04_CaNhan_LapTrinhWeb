<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Form Category</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2>${category != null ? "Cập nhật Category" : "Thêm mới Category"}</h2>

    <form action="${pageContext.request.contextPath}/category" method="post" class="mt-3">
        <input type="hidden" name="id" value="${category.id}"/>

        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" name="name" value="${category.name}" class="form-control" required/>
        </div>

        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <input type="text" name="description" value="${category.description}" class="form-control"/>
        </div>

        <button type="submit" class="btn btn-success">Lưu</button>
        <a href="${pageContext.request.contextPath}/category" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
