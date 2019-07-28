package com.fluex404.springbootjpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fluex404.springbootjpa.model.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

}
