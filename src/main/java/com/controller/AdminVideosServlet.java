package com.controller;

import com.dao.VideoDAO;
import com.entity.Video;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminVideosServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để hiển thị danh sách video (tiêu đề, mô tả tiếng Việt) lên trang quản trị không bị lỗi font
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Video> videos = videoDAO.findAll();
        req.setAttribute("videos", videos);
        RequestDispatcher rd = req.getRequestDispatcher("/admin/videos.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // BẮT BUỘC: Đặt mã hóa UTF-8 lên đầu để khi lấy title, description tiếng Việt từ Form không bị lỗi font
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            Video v = new Video(
                req.getParameter("id"),
                req.getParameter("title"),
                req.getParameter("poster"),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("views")),
                Boolean.parseBoolean(req.getParameter("active"))
            );
            videoDAO.insert(v);
        } else if ("update".equals(action)) {
            Video v = new Video(
                req.getParameter("id"),
                req.getParameter("title"),
                req.getParameter("poster"),
                req.getParameter("description"),
                Integer.parseInt(req.getParameter("views")),
                Boolean.parseBoolean(req.getParameter("active"))
            );
            videoDAO.update(v);
        } else if ("delete".equals(action)) {
            videoDAO.delete(req.getParameter("id"));
        }
        
        // Điều hướng an toàn tuyệt đối tránh lỗi 404 bậy bạ
        resp.sendRedirect(req.getContextPath() + "/adminVideos");
    }
}