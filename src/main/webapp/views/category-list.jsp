<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Danh sách Category</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Danh sách Category</h2>

    <c:if test="${sessionScope.account.role == 'ADMIN'}">
        <a href="${pageContext.request.contextPath}/category?action=new" class="btn btn-primary mb-3">+ Thêm Category</a>
    </c:if>

    <table class="table table-bordered table-striped">
        <thead class="table-dark">
        <tr>
            <th>ID</th>
            <th>Tên</th>
            <th>Mô tả</th>
            <c:if test="${sessionScope.account.role == 'ADMIN'}">
                <th>Hành động</th>
            </c:if>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${list}">
            <tr>
                <td>${c.id}</td>
                <td>${c.name}</td>
                <td>${c.description}</td>
                <c:if test="${sessionScope.account.role == 'ADMIN'}">
                    <td>
                        <a class="btn btn-sm btn-warning" href="${pageContext.request.contextPath}/category?action=edit&id=${c.id}">Sửa</a>
                        <a class="btn btn-sm btn-danger" href="${pageContext.request.contextPath}/category?action=delete&id=${c.id}"
                           onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a>
                    </td>
                </c:if>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <a class="btn btn-secondary" href="${pageContext.request.contextPath}/waiting">Quay lại</a>
</div>
</body>
</html>
