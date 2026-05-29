package com.controller;

import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AuthServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để xử lý dữ liệu và hiển thị thông báo tiếng Việt không bị lỗi font
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        if ("login".equals(action)) {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            User user = userDAO.login(username, password);
            
            if (user != null) {
                req.getSession().setAttribute("user", user);
                // Điều hướng về trang chủ một cách an toàn dùng Context Path
                resp.sendRedirect(req.getContextPath() + "/home");
            } else {
                // Nhờ có UTF-8 ở trên, dòng thông báo này hiển thị ở login.jsp sẽ chuẩn tiếng Việt
                req.setAttribute("error", "Sai tài khoản hoặc mật khẩu!");
                req.getRequestDispatcher("login.jsp").forward(req, resp);
            }
        } else if ("logout".equals(action)) {
            req.getSession().invalidate();
            // Điều hướng về trang chủ sau khi đăng xuất
            resp.sendRedirect(req.getContextPath() + "/home");
        }
    }
}