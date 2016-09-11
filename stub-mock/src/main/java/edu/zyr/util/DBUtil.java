package edu.zyr.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class DBUtil {
    private Connection conn = CreateConnertion.getConnertion();
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean updateDB(String sql, Object... objects) {
        int count = 0;
        try {
            ps = this.conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1, objects[i]);
            }
            count = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            //closeAll();
        }

        return count > 0 ? true : false;
    }

    public ResultSet queryDB(String sql, Object... objects) {
        try {
            ps = this.conn.prepareStatement(sql);
            for (int i = 0; i < objects.length; i++) {
                ps.setObject(i+1,objects[i]);
            }
            rs = ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public void closeAll() {
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
