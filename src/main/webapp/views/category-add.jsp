<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
    <title>Thêm Category</title>
    <meta charset="UTF-8"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="bg-light">
<div class="container mt-5">
    <h2 class="mb-4">Thêm Category</h2>
    <form action="${pageContext.request.contextPath}/category" method="post" enctype="multipart/form-data">
        <div class="mb-3">
            <label class="form-label">Tên</label>
            <input type="text" name="name" class="form-control" required/>
        </div>
        <div class="mb-3">
            <label class="form-label">Mô tả</label>
            <textarea name="description" class="form-control"></textarea>
        </div>
        <div class="mb-3">
            <label class="form-label">Hình ảnh</label>
            <input type="file" name="image" class="form-control" accept="image/*"/>
        </div>
        <button type="submit" class="btn btn-primary">Thêm</button>
        <a href="${pageContext.request.contextPath}/category" class="btn btn-secondary">Quay lại</a>
    </form>
</div>
</body>
</html>
