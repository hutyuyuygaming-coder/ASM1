package com.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcHelper {
    // ✅ Thêm encrypt và trustServerCertificate để bỏ qua kiểm tra chứng chỉ SSL
    private static final String URL = 
        "jdbc:sqlserver://localhost:1433;"
        + "databaseName=OEEntertainment;"
        + "encrypt=true;"
        + "trustServerCertificate=true;";

    private static final String USER = "sa";       // thay bằng user SQL Server của bạn
    private static final String PASSWORD = "123456"; // thay bằng mật khẩu SQL Server của bạn

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Không tìm thấy driver SQL Server!", e);
        }
    }

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static int executeUpdate(String sql, Object... args) {
        try (Connection conn = openConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            for (int i = 0; i < args.length; i++) {
                stmt.setObject(i + 1, args[i]);
            }
            return stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet executeQuery(String sql, Object... args) throws SQLException {
        Connection conn = openConnection();
        PreparedStatement stmt = conn.prepareStatement(sql);
        for (int i = 0; i < args.length; i++) {
            stmt.setObject(i + 1, args[i]);
        }
        return stmt.executeQuery();
    }
}
