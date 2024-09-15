package com.kodbook.com.kodbook.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodbook.com.kodbook.entities.Post;
import com.kodbook.com.kodbook.repository.PostRepository;


@Service
public class PostServiceImplementation implements PostService {

	 @Autowired
	    PostRepository repo;
		
		@Override
		public void createPost(Post post) {
			
			repo.save(post);
			
		}

		@Override
		public List<Post> featchData() {
			
			return repo.findAll();
		}


		@Override
		public void updatePost(Post post) {
			repo.save(post);
		}

		@Override
		public Post getPost(Long id) {
			return repo.findById(id).get();
			
		}

		@Override
		public void updateComments(Post post) {
			repo.save(post);
			
		}
}
