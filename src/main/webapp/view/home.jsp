<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Đặt tiêu đề trang và nội dung riêng cho trang chủ
    request.setAttribute("pageTitle", "Trang chủ");
    request.setAttribute("pageContent", "homeContent.jsp");
%>
<jsp:include page="layout.jsp" />