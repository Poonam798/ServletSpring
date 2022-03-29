package com.bookapp.model.service;

import com.bookapp.model.dao.user.User;

public interface UserService {
	public void addUser(User user);
	public User getUser(String username, String password);
}
