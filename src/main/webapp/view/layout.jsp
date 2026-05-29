<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title><c:out value="${pageTitle}" /></title>
    <style>
        .video-grid {
            display: grid;
            grid-template-columns: repeat(auto-fill, minmax(280px, 1fr));
            gap: 20px;
            margin-top: 20px;
        }

        .video-card {
            background: #fff;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0,0,0,0.1);
            overflow: hidden;
            transition: transform 0.2s ease, box-shadow 0.2s ease;
        }

        .video-card:hover {
            transform: translateY(-5px);
            box-shadow: 0 8px 16px rgba(0,0,0,0.2);
        }

        .video-card img {
            width: 100%;
            height: 160px;
            object-fit: cover;
        }

        .video-info {
            padding: 15px;
        }

        .video-info h3 {
            margin: 0;
            font-size: 18px;
            color: #3498db;
        }

        .video-info h3 a {
            text-decoration: none;
            color: inherit;
        }

        .video-info h3 a:hover {
            text-decoration: underline;
        }

        .video-info p {
            margin: 8px 0;
            color: #555;
        }

        .views {
            font-size: 0.9em;
            color: #888;
        }

        .status {
            font-weight: bold;
            font-size: 0.9em;
        }

        .status.active {
            color: green;
        }

        .status.inactive {
            color: red;
        }

        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f0f4f8, #d9e4f5);
            margin: 0;
        }
        header {
            background: #3498db;
            color: #fff;
            padding: 15px;
            text-align: center;
        }
        nav {
            background: #2c3e50;
            padding: 10px;
            text-align: center;
        }
        nav a {
            color: #fff;
            text-decoration: none;
            margin: 0 15px;
            font-weight: bold;
        }
        nav a:hover {
            text-decoration: underline;
        }
        main {
            padding: 20px;
        }
        footer {
            background: #3498db;
            color: #fff;
            text-align: center;
            padding: 10px;
            margin-top: 30px;
        }
    </style>
</head>
<body>
    <header>
        <h1>🎬 OEEntertainment</h1>
    </header>
    <nav>
    <a href="${pageContext.request.contextPath}/home">Trang chủ</a>
    <a href="#">Thể loại</a>
    <a href="#">Phim mới</a>
    <a href="#">Liên hệ</a>
    
    <c:choose>
        <c:when test="${empty sessionScope.currentUser}">
            <a href="${pageContext.request.contextPath}/login" style="float: right; color: #f1c40f;">🔐 Đăng nhập</a>
        </c:when>
        <c:otherwise>
            <div style="float: right; display: inline-block;">
                <span style="color: #2ecc71; font-weight: bold; margin-right: 10px;">👋 Xin chào, ${sessionScope.currentUser.fullname}</span>
                <a href="${pageContext.request.contextPath}/logout" style="color: #e74c3c; margin-left: 5px;">🚪 Đăng xuất</a>
            </div>
            </c:otherwise>
        </c:choose>
    </nav>
    <main>
        <jsp:include page="${pageContent}" />
    </main>
    <footer>
        <p>&copy; 2026 OEEntertainment. All rights reserved.</p>
    </footer>
</body>
</html>