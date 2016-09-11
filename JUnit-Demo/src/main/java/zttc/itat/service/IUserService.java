package zttc.itat.service;

import zttc.itat.model.User;

public interface IUserService {
	public void add(User user);
	
	public void delete(String username);
	
	public User load(String username);
	
	public User login(String username, String password);
}
