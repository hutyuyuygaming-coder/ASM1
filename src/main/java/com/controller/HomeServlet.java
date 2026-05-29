package com.controller;

import com.dao.VideoDAO;
import com.entity.Video;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class HomeServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // BẮT BUỘC: Cấu hình UTF-8 để dữ liệu danh sách video (tiêu đề, mô tả tiếng Việt) 
        // hiển thị mượt mà lên trang home.jsp không còn bị lỗi font chữ nữa
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy danh sách toàn bộ video từ DB
        List<Video> videos = videoDAO.findAll();
        req.setAttribute("videos", videos);
        
        // Forward tới file home.jsp trong thư mục /view
        RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
        rd.forward(req, resp);
    }
}