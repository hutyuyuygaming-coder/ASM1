package com.controller;

import com.dao.VideoDAO;
import com.entity.Video;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
    private VideoDAO videoDAO = new VideoDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        // Lấy ID từ URL và cắt bỏ khoảng trắng thừa
        String idParam = req.getParameter("id");
        String youtubeId = (idParam != null) ? idParam.trim() : "";

        // Tìm video trong DB
        Video video = videoDAO.findById(youtubeId);

        // Gắn video vào request để JSP hiển thị
        req.setAttribute("video", video);

        // Chuyển hướng
        RequestDispatcher rd = req.getRequestDispatcher("/view/detail.jsp");
        rd.forward(req, resp);
    }
}