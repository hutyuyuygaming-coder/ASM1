<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<h2>Danh sách Video</h2>
<div class="video-grid">
    <c:forEach var="v" items="${videos}">
        <c:if test="${v.active}">
            <div class="video-card">
                <div class="poster-container" style="position: relative;">
                    <img src="${v.poster}" alt="${v.title} poster" style="width: 100%; height: 160px; object-fit: cover;"/>
                </div>
                <div class="video-info">
                    <h3><a href="${pageContext.request.contextPath}/detail?id=${v.youtubeId}">${v.title}</a></h3>
                    <p style="font-size: 0.9em; color: #666; height: 40px; overflow: hidden; margin: 8px 0;">${v.description}</p>
                    <p class="views">🔹 ${v.views} lượt xem</p>
                    
                    <div class="video-actions" style="margin-top: 15px; display: flex; gap: 10px;">
                        <a href="${pageContext.request.contextPath}/detail?id=${v.youtubeId}" 
                        style="flex: 1; text-align: center; background: #3498db; color: white; padding: 6px; text-decoration: none; border-radius: 5px; font-size: 0.9em; font-weight: bold;">
                        Xem chi tiết
                        </a>
                        <a href="#" style="padding: 6px 10px; background: #e74c3c; color: white; text-decoration: none; border-radius: 5px; font-size: 0.9em;">
                        ❤️ Thích
                        </a>
                        <a href="#" style="padding: 6px 10px; background: #2ecc71; color: white; text-decoration: none; border-radius: 5px; font-size: 0.9em;">
                        🔗 Chia sẻ
                        </a>
                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
</div>