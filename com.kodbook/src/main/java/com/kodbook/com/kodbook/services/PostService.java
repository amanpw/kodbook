package com.kodbook.com.kodbook.services;

import java.util.List;

import com.kodbook.com.kodbook.entities.Post;

public interface PostService {

	void createPost(Post post);

	List<Post> featchData();

	void updatePost(Post post);

	Post getPost(Long id);

	void updateComments(Post post);

}
