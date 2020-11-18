package com.hyuk.homework.class10.homework06;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * @author : Hyuk
 * @description : PrePareStatementTest
 * @date : 2020/11/18 10:41 下午
 */
public class PrePareStatementTest {


    public static void main(String[] args) {

    }

    public static void batchInsert() {

        try (Connection conn = JDBCUtil.getConnection();
             PreparedStatement pstm = conn.prepareStatement("INSERT INTO t_user (name,age) VALUES(?,?)")) {
            conn.setAutoCommit(false);
            pstm.setString(1, "hyuk03");
            pstm.setInt(2,26);
            pstm.addBatch();

            pstm.setString(1, "hyuk04");
            pstm.setInt(2,27);
            pstm.addBatch();

            pstm.setString(1, "hyuk05");
            pstm.setInt(2,28);
            pstm.addBatch();

            pstm.executeBatch();
            conn.commit();//2,进行手动提交（commit）
            System.out.println("提交成功!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
