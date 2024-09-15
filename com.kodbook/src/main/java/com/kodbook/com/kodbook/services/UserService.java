package com.kodbook.com.kodbook.services;

import com.kodbook.com.kodbook.entities.User;

public interface UserService {

	boolean existUser(String username , String email);
	public void addUser(User user);
	public boolean checkdata(String username, String password);
}
