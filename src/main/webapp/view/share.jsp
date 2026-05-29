<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Chia sẻ Video</title></head>
<body>
<h2>Danh sách chia sẻ</h2>
<c:forEach var="s" items="${shares}">
    <div>
        <p>Video ID: ${s.videoId} - Email: ${s.email} - Ngày chia sẻ: ${s.sharedDate}</p>
    </div>
</c:forEach>
</body>
</html>
