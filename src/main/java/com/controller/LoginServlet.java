package com.controller;

import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        
        String userParam = req.getParameter("username");
        String passParam = req.getParameter("password");
        
        String username = (userParam != null) ? userParam.trim() : "";
        String password = (passParam != null) ? passParam.trim() : "";

        // Gọi thẳng hàm login từ UserDAO của bạn
        User user = userDAO.login(username, password); 

        if (user != null) {
            // Tùy chọn thêm: Kiểm tra xem tài khoản có bị khóa không (dựa vào cột active)
            if (user.isActive()) {
                HttpSession session = req.getSession();
                session.setAttribute("currentUser", user);
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                req.setAttribute("error", "Tài khoản của bạn đã bị khóa. Vui lòng liên hệ Admin!");
                req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
            }
        } else {
            req.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không chính xác!");
            req.getRequestDispatcher("/view/login.jsp").forward(req, resp);
        }
    }
}