package com.hyuk.homework.class10.homework06;

import java.sql.*;

/**
 * @author : Hyuk
 * @description : JdbcTest
 * @date : 2020/11/18 10:25 下午
 */
public class JdbcTest {

    public static void main(String[] args) {
        insert();

        delete(1L);

        update();

        query();
    }

    // 增
    public static void insert() {
        String sql = "INSERT INTO t_user (name,age) VALUES('hyuk','26')";
        try (Connection conn = JDBCUtil.getConnection();
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 删
     */
    public static void delete(long id) {
        String sql = "delete from t_user where id = " + id;
        try (Connection conn = JDBCUtil.getConnection();
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 改
     */
    public static void update() {
        String sql = "UPDATE t_user SET name = 'hyuk02'";
        try (Connection conn = JDBCUtil.getConnection();
             Statement statement = conn.createStatement()) {
            statement.execute(sql);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 查找数据
     */
    public static void query() {
        String sql = "SELECT * FROM t_user";
        try (Connection conn = JDBCUtil.getConnection();
             Statement statement = conn.createStatement()) {
            //执行查询语句并返回结果集
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                //注意：这里要与数据库里的字段对应
                Long id = resultSet.getLong("id");
                String name = resultSet.getString("name");
                String age = resultSet.getString("age");
                System.out.println("id = " + id);
                System.out.println("name = " + name);
                System.out.println("age = " + age);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
