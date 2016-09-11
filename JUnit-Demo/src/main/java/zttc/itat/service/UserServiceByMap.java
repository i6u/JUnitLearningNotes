package zttc.itat.service;

import java.util.HashMap;
import java.util.Map;

import zttc.itat.model.User;
import zttc.itat.model.UserException;

public class UserServiceByMap implements IUserService {
	private Map<String,User> us = new HashMap<String,User>();

	@Override
	public void add(User user) {
		if(load(user.getUsername())!=null)
			throw new UserException("用户名已经存在");
		us.put(user.getUsername(), user);
	}

	@Override
	public void delete(String username) {
		if(username.equals("superadmin")) return;
		us.remove(username);
	}

	@Override
	public User load(String username) {
		return us.get(username);
	}

	@Override
	public User login(String username, String password) {
		User u = load(username);
		if(u==null) throw new UserException("用户名不存在");
		if(!u.getPassword().equals(password)) throw new UserException("用户密码不存在");
		return u;
	}

}
