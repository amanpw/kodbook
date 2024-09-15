package com.kodbook.com.kodbook.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kodbook.com.kodbook.entities.Post;
import com.kodbook.com.kodbook.services.PostServiceImplementation;
@Controller
public class PostControllers {

	@Autowired
	 PostServiceImplementation service;
	@PostMapping("/newPost")
	public String newPost(@RequestParam ("caption") String caption
			, @RequestParam ("photo") MultipartFile photo , Model model
			) {
		Post post = new Post();
		post.setCaption(caption);
		try {
			post.setPhoto(photo.getBytes());
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		service.createPost(post);
		
	List<Post> allPost =	service.featchData();
	model.addAttribute("allPost", allPost);
		return "home";
	}
	@PostMapping("/likePost")
	public String likePost( @RequestParam ("id") Long id , Model model ){
		Post post = service.getPost(id);
		 post.setLikes(post.getLikes() + 1);
		 service.updatePost(post);
		 List<Post> allPost =	service.featchData();
		 model.addAttribute("allPost", allPost);
		return "home";
	}
	
	@GetMapping("/post")
	public String post(Model model) {
		 List<Post> allPost =	service.featchData();
		 model.addAttribute("allPost", allPost);
		return "home";
	}
	@PostMapping("/addComment")
	public String addComment(@RequestParam ("id") Long id ,  @RequestParam List<String> comments , Model model) {
		Post post = service.getPost(id);
	    
		post.setComments(comments);
		service.updateComments(post);
		 List<Post> allPost =	service.featchData();
		
		 model.addAttribute("allPost", allPost);
		return "home";
		
	
	}
	@GetMapping("/home")
	public String home(Model model) {
		 List<Post> allPost =	service.featchData();
			
		 model.addAttribute("allPost", allPost);
		return "home";
	}
}
