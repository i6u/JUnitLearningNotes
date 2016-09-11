package edu.zyr.service;

import edu.zyr.model.User;

/**
 * Created by zhouweitao on 16/9/10.
 */
public interface IUserService {
    boolean addUser(User user);

    boolean delUser(User user);

    User loadUserByUsername(String username);

    User login(String username, String password);
}
