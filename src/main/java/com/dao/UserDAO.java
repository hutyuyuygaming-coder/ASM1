package com.dao;

import com.entity.User;
import com.utils.JdbcHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    // Thêm user mới (đăng ký)
    public void insert(User user) {
        String sql = "INSERT INTO Users (username, password, fullname, email, role, active) VALUES (?, ?, ?, ?, ?, ?)";
        JdbcHelper.executeUpdate(sql,
                user.getUsername(),
                user.getPassword(),
                user.getFullname(),
                user.getEmail(),
                user.getRole(),
                user.isActive());
    }

    // Cập nhật thông tin user
    public void update(User user) {
        String sql = "UPDATE Users SET password=?, fullname=?, email=?, role=?, active=? WHERE username=?";
        JdbcHelper.executeUpdate(sql,
                user.getPassword(),
                user.getFullname(),
                user.getEmail(),
                user.getRole(),
                user.isActive(),
                user.getUsername());
    }

    // Xóa user
    public void delete(String username) {
        String sql = "DELETE FROM Users WHERE username=?";
        JdbcHelper.executeUpdate(sql, username);
    }

    // Tìm tất cả user
    public List<User> findAll() {
        String sql = "SELECT * FROM Users";
        List<User> list = new ArrayList<>();
        try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
            while (rs.next()) {
                list.add(readFromResultSet(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    // Tìm user theo username
    public User findById(String username) {
        String sql = "SELECT * FROM Users WHERE username=?";
        try (ResultSet rs = JdbcHelper.executeQuery(sql, username)) {
            if (rs.next()) {
                return readFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    // Đăng nhập
    public User login(String username, String password) {
        String sql = "SELECT * FROM Users WHERE username=? AND password=?";
        try (ResultSet rs = JdbcHelper.executeQuery(sql, username, password)) {
            if (rs.next()) {
                return readFromResultSet(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public int count() {
    String sql = "SELECT COUNT(*) FROM Users";
    try (ResultSet rs = JdbcHelper.executeQuery(sql)) {
        if (rs.next()) {
            return rs.getInt(1);
        }
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
    return 0;
}

    public void toggleActive(String username) {
    String sql = "UPDATE Users SET active = CASE WHEN active = 1 THEN 0 ELSE 1 END WHERE username = ?";
    try {
        JdbcHelper.executeUpdate(sql, username);
    } catch (Exception e) {
        throw new RuntimeException(e);
    }
}


    // Helper: chuyển ResultSet thành User object
    private User readFromResultSet(ResultSet rs) throws SQLException {
        User user = new User();
        user.setId(rs.getInt("id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setFullname(rs.getString("fullname"));
        user.setEmail(rs.getString("email"));
        user.setRole(rs.getString("role"));
        user.setActive(rs.getBoolean("active"));
        return user;
    }
}
