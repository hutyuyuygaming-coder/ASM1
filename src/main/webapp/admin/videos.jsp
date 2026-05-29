<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Quản lý Video</title></head>
<body>
<h2>Quản lý Video</h2>

<h3>Thêm Video mới</h3>
<form action="adminVideos" method="post">
    <input type="hidden" name="action" value="add" />
    <input type="text" name="id" placeholder="ID" required /><br/>
    <input type="text" name="title" placeholder="Tiêu đề" required /><br/>
    <textarea name="description" placeholder="Mô tả"></textarea><br/>
    <input type="text" name="url" placeholder="URL" required /><br/>
    <button type="submit">Thêm</button>
</form>

<h3>Danh sách Video</h3>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tiêu đề</th>
        <th>Mô tả</th>
        <th>URL</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="v" items="${videos}">
        <tr>
            <td>${v.id}</td>
            <td>${v.title}</td>
            <td>${v.description}</td>
            <td><a href="${v.url}" target="_blank">Xem</a></td>
            <td>
                <form action="adminVideos" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="id" value="${v.id}" />
                    <button type="submit">Xóa</button>
                </form>
                <form action="adminVideos" method="post" style="display:inline">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="id" value="${v.id}" />
                    <button type="submit">Sửa</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
