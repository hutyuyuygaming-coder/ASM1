package com.dao;

import com.entity.Favorite;
import com.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavoriteDAO {

    // Thêm video vào danh sách yêu thích
    public void insert(Favorite fav) {
        String sql = "INSERT INTO Favorites (userId, videoId, likedDate) VALUES (?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                fav.getUserId(),
                fav.getVideoId(),
                new java.sql.Date(fav.getLikedDate().getTime()));
    }

    // Xóa video khỏi danh sách yêu thích
    public void delete(int id) {
        String sql = "DELETE FROM Favorites WHERE id=?";
        JdbcHelper.executeUpdate(sql, id);
    }

    public int count() {
    String sql = "SELECT COUNT(*) FROM Favorites";
    try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return 0;
}


    // Tìm tất cả favorites của một user
    public List<Favorite> findByUser(int userId) {
        String sql = "SELECT * FROM Favorites WHERE userId=?";
        List<Favorite> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(sql, userId)) {
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Tìm tất cả favorites theo video
    public List<Favorite> findByVideo(String videoId) {
        String sql = "SELECT * FROM Favorites WHERE videoId=?";
        List<Favorite> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(sql, videoId)) {
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Helper: chuyển ResultSet thành Favorite object
    private Favorite readFromResultSet(ResultSet rs) throws SQLException {
        Favorite fav = new Favorite();
        fav.setId(rs.getInt("id"));
        fav.setUserId(rs.getInt("userId"));
        fav.setVideoId(rs.getString("videoId"));
        fav.setLikedDate(rs.getDate("likedDate"));
        return fav;
    }
}
