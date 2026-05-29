<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head><title>Video yêu thích</title></head>
<body>
<h2>Danh sách Video yêu thích</h2>
<c:forEach var="f" items="${favorites}">
    <div>
        <p>Video ID: ${f.videoId} - Ngày thích: ${f.likedDate}</p>
    </div>
</c:forEach>
</body>
</html>
