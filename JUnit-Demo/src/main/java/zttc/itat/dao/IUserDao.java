package zttc.itat.dao;

import zttc.itat.model.User;

public interface IUserDao {
	public void add(User user);
	public void delete(String username);
	public User load(String username);
}
