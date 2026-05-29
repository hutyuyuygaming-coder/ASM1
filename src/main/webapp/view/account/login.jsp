<html>
<head><title>Đăng nhập</title></head>
<body>
<h2>Đăng nhập</h2>
<form action="auth" method="post">
    <input type="hidden" name="action" value="login" />
    <input type="text" name="username" placeholder="Tên đăng nhập" required /><br/>
    <input type="password" name="password" placeholder="Mật khẩu" required /><br/>
    <button type="submit">Đăng nhập</button>
</form>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
