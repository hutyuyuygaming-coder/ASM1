<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // Đặt tiêu đề trang và nội dung riêng
    request.setAttribute("pageTitle", "Chi tiết Video");
    request.setAttribute("pageContent", "detailContent.jsp");
%>
<jsp:include page="layout.jsp" />
