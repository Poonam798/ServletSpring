package com.bookapp.model.dao.user;

public interface UserDao {
	public void addUser(User user);
	public User getUser(String username, String password);
}
