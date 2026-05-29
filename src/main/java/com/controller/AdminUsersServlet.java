package com.controller;

import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminUsersServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để hiển thị danh sách người dùng có tên tiếng Việt không bị lỗi font
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<User> users = userDAO.findAll();
        req.setAttribute("users", users);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/users.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để tiếp nhận các tham số gửi từ form lên một cách chính xác
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");
        String username = req.getParameter("username");

        if ("delete".equals(action)) {
            userDAO.delete(username);
        } else if ("toggleActive".equals(action)) {
            userDAO.toggleActive(username);
        }
        
        // Sử dụng req.getContextPath() để điều hướng về trang quản lý user một cách an toàn
        resp.sendRedirect(req.getContextPath() + "/adminUsers");
    }
}