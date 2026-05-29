package com.controller;

import com.dao.UserDAO;
import com.dao.VideoDAO;
import com.dao.FavoriteDAO;
import com.dao.ShareDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class ReportsServlet extends HttpServlet {
    private UserDAO userDAO = new UserDAO();
    private VideoDAO videoDAO = new VideoDAO();
    private FavoriteDAO favoriteDAO = new FavoriteDAO();
    private ShareDAO shareDAO = new ShareDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để đảm bảo toàn bộ giao diện và dữ liệu báo cáo tiếng Việt hiển thị chính xác
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy dữ liệu thống kê tổng số lượng từ các DAO
        int userCount = userDAO.count();
        int videoCount = videoDAO.count();
        int favoriteCount = favoriteDAO.count();
        int shareCount = shareDAO.count();

        // Gắn dữ liệu vào request để đẩy sang file JSP hiển thị
        req.setAttribute("userCount", userCount);
        req.setAttribute("videoCount", videoCount);
        req.setAttribute("favoriteCount", favoriteCount);
        req.setAttribute("shareCount", shareCount);

        // Forward sang trang báo cáo nằm trong thư mục admin
        RequestDispatcher rd = req.getRequestDispatcher("/admin/reports.jsp");
        rd.forward(req, resp);
    }
}