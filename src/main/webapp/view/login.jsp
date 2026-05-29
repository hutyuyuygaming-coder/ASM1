<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - OEEntertainment</title>
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
        .login-container {
            background: #fff;
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 8px 24px rgba(0,0,0,0.15);
            width: 100%;
            max-width: 380px;
            text-align: center;
        }
        .login-container h2 {
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
        .form-group input:focus {
            border-color: #3498db;
            outline: none;
        }
        .btn-login {
            width: 100%;
            padding: 12px;
            background: #3498db;
            color: white;
            border: none;
            border-radius: 5px;
            font-size: 1em;
            font-weight: bold;
            cursor: pointer;
            transition: background 0.2s;
            margin-top: 10px;
        }
        .btn-login:hover {
            background: #2980b9;
        }
        .error-msg {
            color: #e74c3c;
            font-size: 0.9em;
            margin-bottom: 15px;
            background: #fde8e7;
            padding: 8px;
            border-radius: 5px;
        }
        .back-home {
            margin-top: 20px;
            display: block;
            color: #3498db;
            text-decoration: none;
            font-size: 0.9em;
        }
        .back-home:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2>🔐 ĐĂNG NHẬP</h2>
    
    <c:if test="${not empty error}">
        <div class="error-msg">${error}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/login" method="POST">
        <div class="form-group">
            <label for="username">Tên đăng nhập / Username</label>
            <input type="text" id="username" name="username" placeholder="Nhập username..." required value="${param.username}">
        </div>
        
        <div class="form-group">
            <label for="password">Mật khẩu</label>
            <input type="password" id="password" name="password" placeholder="Nhập mật khẩu..." required>
        </div>
        
        <button type="submit" class="btn-login">Đăng nhập</button>

        <div style="margin-top: 15px; font-size: 0.9em;">
            Chưa có tài khoản? <a href="${pageContext.request.contextPath}/register" style="color: #3498db; text-decoration: none; font-weight: bold;">Đăng ký ngay</a>
        </div>
    </form>
    
    <a href="${pageContext.request.contextPath}/home" class="back-home">⬅ Quay lại trang chủ</a>
</div>

</body>
</html>