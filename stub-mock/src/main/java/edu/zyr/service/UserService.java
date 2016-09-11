package edu.zyr.service;

import edu.zyr.dao.IUserDao;
import edu.zyr.dao.UserDao;
import edu.zyr.model.User;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class UserService implements IUserService {
    private IUserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public UserService(IUserDao userDao) {
        this.userDao = userDao;
    }

    public boolean addUser(User user) {
        return userDao.addUser(user);
    }

    public boolean delUser(User user) {
        return userDao.delUser(user);
    }

    public User loadUserByUsername(String username) {
        return userDao.loadUserByUsername(username);
    }

    public User login(String username, String password) {
        return userDao.login(username,password);
    }
}
