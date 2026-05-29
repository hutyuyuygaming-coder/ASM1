package com.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        // Hủy bỏ toàn bộ session hiện tại
        HttpSession session = req.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Quay lại trang chủ sau khi đăng xuất
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}