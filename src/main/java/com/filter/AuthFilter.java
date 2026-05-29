package com.filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class AuthFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Có thể dùng để load config từ web.xml nếu cần
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        HttpSession session = req.getSession(false);

        // Lấy URL người dùng đang truy cập
        String uri = req.getRequestURI();

        // Kiểm tra nếu chưa đăng nhập mà lại truy cập vào trang bảo vệ
        if (session == null || session.getAttribute("user") == null) {
            // Cho phép truy cập các trang public (login, register, home)
            if (uri.contains("login") || uri.contains("register") || uri.contains("home")) {
                chain.doFilter(request, response);
            } else {
                // Nếu không, redirect về trang login
                res.sendRedirect(req.getContextPath() + "/login");
            }
        } else {
            // Nếu đã đăng nhập thì cho đi tiếp
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Dọn dẹp resource nếu cần
    }
}
