package edu.zyr.dao;

import edu.zyr.model.User;

/**
 * Created by zhouweitao on 16/9/10.
 */
public interface IUserDao {
    boolean addUser(User user);

    boolean delUser(User user);

    User loadUserByUsername(String username);

    User login(String username, String password);
}
