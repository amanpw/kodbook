package com.kodbook.com.kodbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodbook.com.kodbook.entities.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
