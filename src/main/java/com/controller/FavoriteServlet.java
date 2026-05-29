package com.controller;

import com.dao.FavoriteDAO;
import com.entity.Favorite;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;
import java.util.List;

public class FavoriteServlet extends HttpServlet {
    private FavoriteDAO favoriteDAO = new FavoriteDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để hiển thị tiêu đề video yêu thích bằng tiếng Việt không bị lỗi font
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        User user = (User) req.getSession().getAttribute("user");
        if (user != null) {
            List<Favorite> favorites = favoriteDAO.findByUser(user.getId());
            req.setAttribute("favorites", favorites);
            RequestDispatcher rd = req.getRequestDispatcher("favorites.jsp");
            rd.forward(req, resp);
        } else {
            // Sử dụng Context Path để chuyển hướng về trang login an toàn
            resp.sendRedirect(req.getContextPath() + "/login.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 cho đồng bộ dữ liệu gửi lên
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        User user = (User) req.getSession().getAttribute("user");
        String videoId = req.getParameter("videoId");
        if (user != null && videoId != null) {
            Favorite fav = new Favorite(0, user.getId(), videoId, new Date());
            favoriteDAO.insert(fav);
        }
        
        // Điều hướng tải lại trang favorites thông qua đường dẫn tuyệt đối của ứng dụng
        resp.sendRedirect(req.getContextPath() + "/favorites");
    }
}