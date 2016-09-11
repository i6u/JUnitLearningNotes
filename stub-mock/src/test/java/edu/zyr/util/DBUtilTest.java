package edu.zyr.util;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class DBUtilTest {
    private DBUtil db;
    @Before
    public void setUp() {
        db = new DBUtil();
    }

    @Test
    public void updateDBTest() {
        String sql = "insert into t_user(username,password,nickname) value('user1','user1','管理员')";
        db.updateDB(sql);
    }

    @Test
    public void delTest(){
        String sql = "delete from t_user where username = ?";
        db.updateDB(sql,"user1");
    }

    @Test
    public void queryDBTest() {
        long is = System.nanoTime();
        String sql = "select * from t_user";
        ResultSet rs = db.queryDB(sql);
        assertNotNull(rs);
        //long ns = System.nanoTime();
        //long ms = System.currentTimeMillis();
    }

    @Test
    public void queryDBTest1() {
        String sql = "select * from t_user where id = ?";
        ResultSet rs = db.queryDB(sql, "1");
        assertNotNull(rs);
    }

}
