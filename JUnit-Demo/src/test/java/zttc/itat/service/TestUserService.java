package zttc.itat.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import zttc.itat.dao.UserStubDao;
import zttc.itat.model.User;
import zttc.itat.model.UserException;

public class TestUserService {
	private IUserService us;
	private User baseUser;
	
	@BeforeClass//在执行构造函数之前会执行这个方法,但是仅仅只会执行一次
	public static void init() {
		System.out.println("before class");
	}
	
	@Before
	public void setUp() {
		//初始化
		us = new UserService(new UserStubDao());
		baseUser = new User("admin","123","管理员");
	}
	
	private void assertUserEquals(User u,User tu) {
		assertEquals(tu.getUsername(), u.getUsername());
		assertEquals(tu.getPassword(), u.getPassword());
		assertEquals(tu.getNickname(), u.getNickname());
	}
	
	@Test
	public void testAdd() {
		User u = baseUser;
		us.add(u);
		User tu = us.load("admin");
		
		assertNotNull(tu);
		assertUserEquals(u, tu);
	}
	
	@Test(expected=UserException.class)
	public void testAddExistUsername() {
		us.add(baseUser);
		User tu = new User("admin","123","123");
		us.add(tu);
	}
	
	@Test
	public void testDelete() {
		us.add(baseUser);
		User tu = us.load(baseUser.getUsername());
		assertNotNull(tu);
		us.delete(baseUser.getUsername());
		tu = us.load(baseUser.getUsername());
		assertNull("删除的用户还存在",tu);
	}
	
	@Test
	public void testLogin() {
		us.add(baseUser);
		String username = "admin";
		String password = "123";
		User tu = us.login(username, password);
		assertUserEquals(baseUser, tu);
	}
	
	@Test(expected=UserException.class)
	public void testNotExistsUserLogin() {
		us.add(baseUser);
		String username = "admin1";
		String password = "123";
		us.login(username, password);
	}
	
	@Test(expected=UserException.class)
	public void testPasswordErrorUserLogin() {
		us.add(baseUser);
		String username = "admin";
		String password = "1234";
		us.login(username, password);
	}
	
}
