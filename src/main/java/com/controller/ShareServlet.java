package com.controller;

import com.dao.ShareDAO;
import com.entity.Share;
import com.entity.User;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.Date;

public class ShareServlet extends HttpServlet {
    private ShareDAO shareDAO = new ShareDAO();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Cấu hình UTF-8 để đồng bộ hóa dữ liệu tiếp nhận từ form gửi lên
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        User user = (User) req.getSession().getAttribute("user");
        String videoId = req.getParameter("videoId");
        String email = req.getParameter("email");

        if (user != null && videoId != null && email != null) {
            Share share = new Share(0, user.getId(), videoId, email, new Date());
            shareDAO.insert(share);
        }
        
        // Sử dụng req.getContextPath() để điều hướng quay trở lại trang chi tiết video một cách chính xác
        resp.sendRedirect(req.getContextPath() + "/detail?id=" + videoId);
    }
}