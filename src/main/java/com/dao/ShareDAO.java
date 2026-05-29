package com.dao;

import com.entity.Share;
import com.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShareDAO {

    // Thêm chia sẻ mới
    public void insert(Share share) {
        String sql = "INSERT INTO Shares (userId, videoId, email, sharedDate) VALUES (?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                share.getUserId(),
                share.getVideoId(),
                share.getEmail(),
                new java.sql.Date(share.getSharedDate().getTime()));
    }

    // Xóa chia sẻ
    public void delete(int id) {
        String sql = "DELETE FROM Shares WHERE id=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    // Tìm tất cả chia sẻ theo user
    public List<Share> findByUser(int userId) {
        String sql = "SELECT * FROM Shares WHERE userId=?";
        List<Share> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(sql, userId)) {
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    public int count() {
    String sql = "SELECT COUNT(*) FROM Shares";
    try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return 0;
}


    // Tìm tất cả chia sẻ theo video
    public List<Share> findByVideo(String videoId) {
        String sql = "SELECT * FROM Shares WHERE videoId=?";
        List<Share> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(sql, videoId)) {
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Helper: chuyển ResultSet thành Share object
    private Share readFromResultSet(ResultSet rs) throws SQLException {
        Share share = new Share();
        share.setId(rs.getInt("id"));
        share.setUserId(rs.getInt("userId"));
        share.setVideoId(rs.getString("videoId"));
        share.setEmail(rs.getString("email"));
        share.setSharedDate(rs.getDate("sharedDate"));
        return share;
    }
}
