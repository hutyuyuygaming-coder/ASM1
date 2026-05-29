package com.dao;

import com.entity.Video;
import com.utils.JdbcHelper;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VideoDAO {

    // Thêm video mới
    public void insert(Video video) {
        String sql = "INSERT INTO Videos (youtubeId, title, poster, description, views, active) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                video.getYoutubeId(),
                video.getTitle(),
                video.getPoster(),
                video.getDescription(),
                video.getViews(),
                video.isActive());
    }

    // Cập nhật video
    public void update(Video video) {
        String sql = "UPDATE Videos SET title=?, poster=?, description=?, views=?, active=? WHERE youtubeId=?";
        JdbcHelper.executeUpdate(sql,
                video.getTitle(),
                video.getPoster(),
                video.getDescription(),
                video.getViews(),
                video.isActive(),
                video.getYoutubeId());
    }

    // Đếm số lượng video
    public int count() {
        String sql = "SELECT COUNT(*) FROM Videos";
        try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    // Xóa video theo youtubeId
    public void delete(String youtubeId) {
        String sql = "DELETE FROM Videos WHERE youtubeId=?";
        JdbcHelper.executeUpdate(sql, youtubeId != null ? youtubeId.trim() : "");
    }

    // Tìm video theo youtubeId (Đã tối ưu an toàn dữ liệu)
    public Video findById(String youtubeId) {
        // Kiểm tra nếu tham số truyền vào bị rỗng thì ngắt luôn
        if (youtubeId == null || youtubeId.trim().isEmpty()) {
            return null;
        }
        
        String sql = "SELECT * FROM Videos WHERE youtubeId=?";
        try (ResultSet rs = JdbcHelper.executeQuery(sql, youtubeId.trim())) {
            if (rs.next()) {
                return new Video(
                        rs.getString("youtubeId"),
                        rs.getString("title"),
                        rs.getString("poster"),
                        rs.getString("description"),
                        rs.getInt("views"),
                        rs.getBoolean("active")
                );
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi tìm video theo youtubeId: " + youtubeId, e);
        }
        return null;
    }

    // Lấy tất cả video
    public List<Video> findAll() {
        List<Video> list = new ArrayList<>();
        String sql = "SELECT * FROM Videos";
        try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
            while (rs.next()) {
                list.add(new Video(
                        rs.getString("youtubeId"),
                        rs.getString("title"),
                        rs.getString("poster"),
                        rs.getString("description"),
                        rs.getInt("views"),
                        rs.getBoolean("active")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Lỗi khi lấy danh sách video", e);
        }
        return list;
    }
}