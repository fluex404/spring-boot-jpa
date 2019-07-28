package com.fluex404.springbootjpa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fluex404.springbootjpa.exception.ResourceNotFoundException;
import com.fluex404.springbootjpa.model.Post;
import com.fluex404.springbootjpa.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@GetMapping
	public Page<Post> getAllPosts(Pageable pageable) {
		return postRepository.findAll(pageable);
	}
	
	@PostMapping
	public Post createPost(@Valid @RequestBody Post post) {
		return postRepository.save(post);
	}
	
	@PutMapping("/{postId}")
	public Post updatePost(@PathVariable("postId") Long postId, @Valid @RequestBody Post postRequest) {
		
		return postRepository.findById(postId).map(post -> {
			post.setTitle(postRequest.getTitle());
			post.setDescription(postRequest.getDescription());
			post.setContent(postRequest.getContent());
			
			return postRepository.save(post);
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
		
	}
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable("postId") Long postId) {
		return postRepository.findById(postId).map(post -> {
			postRepository.delete(post);
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
	}
}
