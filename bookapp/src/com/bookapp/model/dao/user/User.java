package com.bookapp.model.dao.user;
public class User {
	private int id;
	private String username;
	private String password;
	private String profile;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile() {
		return profile;
	}
	public void setProfile(String profile) {
		this.profile = profile;
	}
	public User(int id, String username, String password, String profile) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.profile = profile;
	}
	public User() {}
	public User(String username, String password, String profile) {
		super();
		this.username = username;
		this.password = password;
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", profile=" + profile + "]";
	}
	
	
}
