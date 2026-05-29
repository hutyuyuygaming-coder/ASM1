<html>
<head><title>Chỉnh sửa thông tin</title></head>
<body>
<h2>Chỉnh sửa thông tin cá nhân</h2>
<form action="editProfile" method="post">
    <input type="text" name="fullname" value="${user.fullname}" placeholder="Họ tên" /><br/>
    <input type="email" name="email" value="${user.email}" placeholder="Email" /><br/>
    <button type="submit">Cập nhật</button>
</form>
</body>
</html>
