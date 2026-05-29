<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng ký - OEEntertainment</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: linear-gradient(135deg, #f0f4f8, #d9e4f5);
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
        }
        .register-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 400px;
            text-align: center;
        }
        .register-container h2 {
            margin-bottom: 20px;
            color: #2c3e50;
        }
        .form-group {
            margin-bottom: 15px;
            text-align: left;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
            color: #666;
            font-size: 0.9em;
        }
        .form-group input {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 1em;
        }
        .btn-register {
            width: 100%;
            padding: 12px;
            background: #2ecc71;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
        }
        .btn-register:hover {
            background: #27ae60;
        }
        .message {
            font-size: 0.9em;
            margin-bottom: 15px;
            padding: 8px;
            border-radius: 5px;
        }
        .error { background: #fde8e7; color: #e74c3c; }
        .success { background: #e8f8f5; color: #2ecc71; }
        .links {
            margin-top: 20px;
            font-size: 0.9em;
        }
        .links a { color: #3498db; text-decoration: none; }
        .links a:hover { text-decoration: underline; }
    </style>
</head>
<body>

<div class="register-container">
    <h2>📝 ĐĂNG KÝ TÀI KHOẢN</h2>
    
    <c:if test="${not empty error}">
        <div class="message error">❌ ${error}</div>
    </c:if>
    <c:if test="${not empty success}">
        <div class="message success">✅ ${success}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="POST">
        <div class="form-group">
            <label>Tên đăng nhập (Username)</label>
            <input type="text" name="username" required>
        </div>
        <div class="form-group">
            <label>Mật khẩu</label>
            <input type="password" name="password" required>
        </div>
        <div class="form-group">
            <label>Họ và tên (Fullname)</label>
            <input type="text" name="fullname" required>
        </div>
        <div class="form-group">
            <label>Email</label>
            <input type="email" name="email" required>
        </div>
        
        <button type="submit" class="btn-register">Đăng ký ngay</button>
    </form>
    
    <div class="links">
        Đã có tài khoản? <a href="${pageContext.request.contextPath}/login">Đăng nhập tại đây</a>
    </div>
</div>

</body>
</html>