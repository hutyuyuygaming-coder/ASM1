<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Báo cáo hệ thống</title></head>
<body>
<h2>Báo cáo tổng quan</h2>
<ul>
    <li>Tổng số người dùng: ${userCount}</li>
    <li>Tổng số video: ${videoCount}</li>
    <li>Tổng số lượt yêu thích: ${favoriteCount}</li>
    <li>Tổng số lượt chia sẻ: ${shareCount}</li>
</ul>
</body>
</html>
