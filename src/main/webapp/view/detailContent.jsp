<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<div class="video-detail" style="max-width: 850px; margin: 0 auto; padding: 25px; background: #fff; border-radius: 10px; box-shadow: 0 4px 12px rgba(0,0,0,0.1);">
    
    <c:if test="${not empty video}">
        <h2 style="color: #2c3e50; margin-top: 0; font-size: 24px;">🎬 ${video.title}</h2>
        
        <div class="video-wrapper" style="position: relative; padding-bottom: 56.25%; height: 0; overflow: hidden; margin: 20px 0; border-radius: 8px; box-shadow: 0 4px 8px rgba(0,0,0,0.15);">
            <iframe src="https://www.youtube.com/embed/${video.youtubeId}" 
                    style="position: absolute; top: 0; left: 0; width: 100%; height: 100%; border: none;" 
                    allowfullscreen>
            </iframe>
        </div>

        <p style="font-size: 1.1em; color: #444; line-height: 1.6; margin-bottom: 10px;">${video.description}</p>
        <p class="views" style="color: #888; font-size: 0.95em; margin-bottom: 20px;">👁️ ${video.views} lượt xem</p>
        
        <div class="action-buttons" style="display: flex; gap: 15px; margin-top: 20px; border-top: 1px solid #eee; padding-top: 20px;">
            <a href="#" style="padding: 10px 20px; background: #e74c3c; color: white; text-decoration: none; border-radius: 5px; font-weight: bold; display: flex; align-items: center; gap: 5px;">
                ❤️ Thích Video này
            </a>
            <a href="#" style="padding: 10px 20px; background: #2ecc71; color: white; text-decoration: none; border-radius: 5px; font-weight: bold; display: flex; align-items: center; gap: 5px;">
                🔗 Chia sẻ cho bạn bè
            </a>
        </div>
    </c:if>

    <c:if test="${empty video}">
        <h3 style="color: red; text-align: center;">❌ Không tìm thấy thông tin chi tiết của video này!</h3>
    </c:if>

    <a href="${pageContext.request.contextPath}/home" style="display:inline-block; margin-top:25px; text-decoration:none; color:#3498db; font-weight:bold; font-size: 0.95em;">
        ⬅ Quay lại danh sách trang chủ
    </a>
</div>