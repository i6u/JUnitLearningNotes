package zttc.itat.dao;

import java.util.HashMap;
import java.util.Map;

import zttc.itat.model.User;

public class UserStubDao implements IUserDao {
	private Map<String,User> us = new HashMap<String,User>();
	
	@Override
	public void add(User user) {
		us.put(user.getUsername(), user);
	}

	@Override
	public void delete(String username) {
		us.remove(username);
	}

	@Override
	public User load(String username) {
		return us.get(username);
	}

}
