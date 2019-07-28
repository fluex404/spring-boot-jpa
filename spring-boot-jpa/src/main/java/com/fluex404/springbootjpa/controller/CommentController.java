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
import com.fluex404.springbootjpa.model.Comment;
import com.fluex404.springbootjpa.repository.CommentRepository;
import com.fluex404.springbootjpa.repository.PostRepository;

@RestController
@RequestMapping("/posts")
public class CommentController {
	
	private CommentRepository commentRepository;
	private PostRepository postRepository;
	
	@Autowired
	public CommentController(CommentRepository commentRepository, PostRepository postRepository) {
		this.commentRepository = commentRepository;
		this.postRepository = postRepository;
	}
	
	@GetMapping("/{postId}/comments")
	public Page<Comment> getAllcommentsByPostId(@PathVariable("postId") Long postId,
			Pageable pageable){
		return commentRepository.findByPostId(postId, pageable);
	}
	
	@PostMapping("/{postId}/comments")
	public Comment createComment(@PathVariable("postId") Long postId, 
			@Valid @RequestBody Comment comment) {
		return postRepository.findById(postId).map(post -> {
			comment.setPost(post);
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("postId "+postId+" Not Found"));
	}
	
	@PutMapping("/{postId}/comments/{commentId}")
	public Comment updateComment(@PathVariable("postId") Long postId, 
			@PathVariable("commentId") Long commentId,
			@Valid @RequestBody Comment commentRequest) {
		
		if(!postRepository.existsById(postId)) {
			throw new ResourceNotFoundException("postId "+postId+" Not Found");
		}
		
		return commentRepository.findById(commentId).map(comment -> {
			comment.setText(commentRequest.getText());
			return commentRepository.save(comment);
		}).orElseThrow(() -> new ResourceNotFoundException("postId "+postId+" Not Found"));
		
	}
	
	@DeleteMapping("/{postId}/comments/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable("postId") Long postId, 
			@PathVariable("commentId") Long commentId) {
		return commentRepository.findByIdAndPostId(commentId, postId).map(comment -> {
			commentRepository.delete(comment);
			
			return ResponseEntity.ok().build();
		}).orElseThrow(() -> new ResourceNotFoundException("Comment not found with id "+commentId+" and postId "+postId));
	}
}
