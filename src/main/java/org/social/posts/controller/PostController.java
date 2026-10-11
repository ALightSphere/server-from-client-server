package org.social.posts.controller;

import org.social.posts.entity.Post;
import org.social.posts.entity.dto.PostContainerDto;
import org.social.posts.entity.dto.PostDto;
import org.social.posts.entity.dto.request.CreatePostRequest;
import org.social.posts.entity.dto.request.UpdatePostRequest;
import org.social.posts.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/public")
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }
    @GetMapping("/posts")
    public PostContainerDto findAll() {
        return postService.findAll();
    }
    @GetMapping("/posts/{postId}")
    public PostDto findById(@PathVariable(name="postId") int id) {
        return postService.findById(id);
    }
    @PostMapping("/posts")
    public PostDto save(@RequestBody CreatePostRequest request) {
        return postService.save(request);
    }
    @PutMapping("/posts/{postId}")
    public PostDto update(@PathVariable(name="postId") int id, @RequestBody UpdatePostRequest request) {
        return postService.update(id, request);
    }
    @DeleteMapping("/posts/{postId}")
    public void delete(@PathVariable(name="postId") int id){
        postService.delete(id);
    }
}
