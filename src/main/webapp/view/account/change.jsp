<html>
<head><title>Đổi mật khẩu</title></head>
<body>
<h2>Đổi mật khẩu</h2>
<form action="changePassword" method="post">
    <input type="password" name="oldPassword" placeholder="Mật khẩu cũ" required /><br/>
    <input type="password" name="newPassword" placeholder="Mật khẩu mới" required /><br/>
    <input type="password" name="confirmPassword" placeholder="Xác nhận mật khẩu mới" required /><br/>
    <button type="submit">Đổi mật khẩu</button>
</form>
<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
