package com.controller;

import com.dao.VideoDAO;
import com.entity.Video;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class AdminServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để hiển thị dữ liệu tiếng Việt lên trang admin.jsp không bị lỗi
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        List<Video> videos = videoDAO.findAll();
        req.setAttribute("videos", videos);
        RequestDispatcher rd = req.getRequestDispatcher("admin.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // BẮT BUỘC: Phải đặt encoding UTF-8 lên đầu hàm doPost trước khi req.getParameter được gọi
        // Nếu không, dữ liệu tiếng Việt từ Form gửi lên sẽ bị lỗi font khi lưu vào DB
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        if ("add".equals(action)) {
            Video video = new Video(
                    req.getParameter("id"),
                    req.getParameter("title"),
                    req.getParameter("poster"),
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("views")),
                    Boolean.parseBoolean(req.getParameter("active"))
            );
            videoDAO.insert(video);
        } else if ("update".equals(action)) {
            Video video = new Video(
                    req.getParameter("id"),
                    req.getParameter("title"),
                    req.getParameter("poster"),
                    req.getParameter("description"),
                    Integer.parseInt(req.getParameter("views")),
                    Boolean.parseBoolean(req.getParameter("active"))
            );
            videoDAO.update(video);
        } else if ("delete".equals(action)) {
            String id = req.getParameter("id");
            videoDAO.delete(id);
        }
        
        // Sử dụng req.getContextPath() để điều hướng về trang admin một cách an toàn và chính xác nhất
        resp.sendRedirect(req.getContextPath() + "/admin");
    }
}