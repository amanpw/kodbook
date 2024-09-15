package com.kodbook.com.kodbook.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class NavbarControllers {

	@GetMapping("/openCreateAccount")
	public String openCreateAccount() {
		return "createAccount";
	}
	
	@GetMapping("/createPost")
	public String createPost() {
		return "createPost";
	}
	
}
