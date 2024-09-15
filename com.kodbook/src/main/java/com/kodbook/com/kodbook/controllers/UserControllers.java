package com.kodbook.com.kodbook.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodbook.com.kodbook.entities.User;
import com.kodbook.com.kodbook.services.UserServiceImplementation;

@Controller
public class UserControllers {
   @Autowired
	UserServiceImplementation service;
	@PostMapping("/createUser")
	public String createUser(@ModelAttribute User user , Model model) {
	boolean status =service.existUser(user.getUsername() , user.getEmail());
	if(status == false) {
		service.addUser(user);
		model.addAttribute("message", "Account create please login");
		return "index";
	}else {
		 model.addAttribute("message", "user already ragister with us");
			return "createAccount";

	}
	}
	@PostMapping("/login")
	public String login(@RequestParam String username , @RequestParam String password , Model model) {
	
		boolean status = service.checkdata(username , password);
		if(status==true) {
			
			model.addAttribute("message", "Welcome to home page");
			return "home";
		}
		model.addAttribute("message", "Please enter valid details");
		return"index";
	}
}
