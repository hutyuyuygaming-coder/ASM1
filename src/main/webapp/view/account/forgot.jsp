<html>
<head><title>Quên mật khẩu</title></head>
<body>
<h2>Quên mật khẩu</h2>
<form action="forgotPassword" method="post">
    <input type="email" name="email" placeholder="Nhập email của bạn" required /><br/>
    <button type="submit">Gửi lại mật khẩu</button>
</form>
<c:if test="${not empty message}">
    <p style="color:green">${message}</p>
</c:if>
<c:if test="${not empty error}">
    <p style="color:red">${error}</p>
</c:if>
</body>
</html>
