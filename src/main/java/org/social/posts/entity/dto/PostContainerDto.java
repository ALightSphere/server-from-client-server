package org.social.posts.entity.dto;

import org.social.posts.entity.Post;

import java.util.List;

public class PostContainerDto {
    private final List<PostDto> posts;

    public PostContainerDto(List<PostDto> posts) {
        this.posts = posts;
    }
    public List<PostDto> getPosts() {
        return posts;
    }
}
