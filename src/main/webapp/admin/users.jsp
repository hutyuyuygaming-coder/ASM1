<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Quản lý Người dùng</title></head>
<body>
<h2>Danh sách Người dùng</h2>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Tên đăng nhập</th>
        <th>Họ tên</th>
        <th>Email</th>
        <th>Vai trò</th>
        <th>Trạng thái</th>
        <th>Hành động</th>
    </tr>
    <c:forEach var="u" items="${users}">
        <tr>
            <td>${u.id}</td>
            <td>${u.username}</td>
            <td>${u.fullname}</td>
            <td>${u.email}</td>
            <td>${u.role}</td>
            <td><c:choose>
                <c:when test="${u.active}">Hoạt động</c:when>
                <c:otherwise>Bị khóa</c:otherwise>
            </c:choose></td>
            <td>
                <form action="adminUsers" method="post" style="display:inline">
                    <input type="hidden" name="action" value="delete" />
                    <input type="hidden" name="username" value="${u.username}" />
                    <button type="submit">Xóa</button>
                </form>
                <form action="adminUsers" method="post" style="display:inline">
                    <input type="hidden" name="action" value="toggleActive" />
                    <input type="hidden" name="username" value="${u.username}" />
                    <button type="submit">
                        <c:choose>
                            <c:when test="${u.active}">Khóa</c:when>
                            <c:otherwise>Mở khóa</c:otherwise>
                        </c:choose>
                    </button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
