package edu.zyr.dao;

import edu.zyr.model.User;
import edu.zyr.util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class UserDao implements IUserDao {
    private DBUtil db;

    public UserDao() {
        db = new DBUtil();
    }
    public boolean addUser(User user) {
        return db.updateDB("insert into t_user (username,password,nickname) value(?,?,?)", user.getUsername(), user.getPassword(), user.getNickname());
    }

    public boolean delUser(User user) {
        return db.updateDB("delete from t_user where name = ?", user.getUsername());
    }

    public User loadUserByUsername(String username) {
        return load(username);
    }

    public User login(String username, String password) {
        return load(username, password);
    }

    private User load(String...strings) {
        String sql;
        ResultSet rs = null;
        User user=null;

        if (strings.length == 1) {
            sql = "select id,username,password,nickname from t_user where username = ? ";
            rs = db.queryDB(sql, strings[0]);
        } else if (strings.length == 2) {
            sql = "select id,username,password,nickname from t_user where username = ? and password=?";
            rs = db.queryDB(sql, strings[0],strings[1]);
        } else {
            return null;
        }
        try {
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setNickname(rs.getString("nickname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;

    }
}
