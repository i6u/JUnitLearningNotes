package edu.zyr.util;

import edu.zyr.model.User;
import edu.zyr.service.IUserService;
import edu.zyr.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by zhouweitao on 16/9/10.
 */
public class UserServiceTest {
    private IUserService us;
    @Before
    public void setUp(){
        us = new UserService();
    }

    @Test
    public void addTest() {
        User user = new User(21,"jobs", "jobs123", "乔布斯");
        us.addUser(user);
        User tu = us.loadUserByUsername("jobs");
        assertEquals("add error--->", user, tu);
    }
}
