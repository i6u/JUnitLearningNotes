package edu.zyr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class CreateConnertion {
    private static Connection conn = null;

    public static Connection getConnertion() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://10.211.55.3:3306/zyr_junit", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static void closed(Connection conn) {
        if (conn!=null) try {
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
