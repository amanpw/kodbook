package com.kodbook.com.kodbook.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.com.kodbook.entities.User;
import com.kodbook.com.kodbook.repository.UserRepository;
@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    UserRepository repo;
	@Override
	public boolean existUser(String username, String email) {
	  User user1 = repo.findByUsername(username);
	  User user2 = repo.findByEmail(email);
	  if(user1!=null||user2!=null) {
		  return true;
	  }
		  return false;
	  
	}
	@Override
	public void addUser(User user) {
		repo.save(user);
	}
	public boolean checkdata(String username, String password) {
	     User user1 = repo.findByUsername(username);
	     String dbpassword = user1.getPassword();
	     if(password.equals(dbpassword)) {
	    	 return true;
	     }
		return false;
	}
}
