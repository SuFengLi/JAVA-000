package com.hyuk.homework.class10.homework06;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author : Hyuk
 * @description : JDBCUtil
 * @date : 2020/11/18 10:41 下午
 */
public class JDBCUtil {

    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/tb_user";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private static HikariDataSource hikariDataSource = null;

    static {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(DB_URL);
        config.setUsername(USER);
        config.setPassword(PASSWORD);
        config.addDataSourceProperty("cachePrepStmts", "true");
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
        hikariDataSource = new HikariDataSource(config);
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }

    public static Connection getHikariDataSourceConnection() throws SQLException {
        return hikariDataSource.getConnection();
    }
}
