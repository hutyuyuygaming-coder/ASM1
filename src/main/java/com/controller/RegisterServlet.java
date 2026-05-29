package com.controller;

import com.dao.UserDAO;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
            throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        
        User newUser = new User();
        newUser.setUsername(req.getParameter("username"));
        newUser.setPassword(req.getParameter("password"));
        newUser.setFullname(req.getParameter("fullname"));
        newUser.setEmail(req.getParameter("email"));
        
        // BẮT BUỘC: Set cứng role là 'user' và active là true (1) theo đúng DAO của bạn
        newUser.setRole("user");
        newUser.setActive(true);

        try {
            // Gọi hàm insert void của bạn
            userDAO.insert(newUser); 
            req.setAttribute("success", "Đăng ký thành công! Vui lòng đăng nhập.");
        } catch (Exception e) {
            // Nếu có lỗi (thường do vi phạm UNIQUE constraint của username)
            req.setAttribute("error", "Đăng ký thất bại! Tên đăng nhập này đã có người sử dụng.");
            System.out.println("Lỗi đăng ký: " + e.getMessage());
        }
        
        req.getRequestDispatcher("/view/register.jsp").forward(req, resp);
    }
}