package org.social.posts.service;

import jakarta.transaction.Transactional;
import org.social.posts.entity.Post;
import org.social.posts.entity.dto.PostContainerDto;
import org.social.posts.entity.dto.PostDto;
import org.social.posts.entity.dto.request.CreatePostRequest;
import org.social.posts.entity.dto.request.UpdatePostRequest;
import org.social.posts.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostService {
    private final PostRepository postRepository;
    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostContainerDto findAll(){
        List<PostDto> posts = postRepository.findAll().stream()
                .map(Post::toDto)
                .collect(Collectors.toList());
        return new PostContainerDto(posts);
    }

    public PostDto findById(int id){
        return postRepository.findById(id)
                .map(Post::toDto)
                .orElseThrow(()-> new IllegalStateException("Post id=" + id + " not found"));
    }

    public PostDto save(CreatePostRequest request){
        Post post = request.toEntity();
        return postRepository.save(post).toDto();
    }
    public PostDto update(int id, UpdatePostRequest request){
        return postRepository.findById(id)
                .map(exitstingPost -> {
                    Post updatedPost = request.toEntity(exitstingPost.getId(), exitstingPost.getDate(), exitstingPost.getAuthor());
                    return postRepository.save(updatedPost).toDto();
                })
                .orElseThrow(()-> new IllegalStateException("Post id=" + id + " not found"));
    }
    public void delete(int id){
        postRepository.deleteById(id);
    }
}
