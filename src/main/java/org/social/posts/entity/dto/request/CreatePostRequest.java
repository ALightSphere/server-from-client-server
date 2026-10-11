package org.social.posts.entity.dto.request;

import org.social.posts.entity.Post;

import java.time.LocalDateTime;

public class CreatePostRequest {
    private final String title;
    private final String author;

    public CreatePostRequest(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public Post toEntity(){
        return new Post(
                author,
                LocalDateTime.now(),
                0,
                0,
                0,
                title
        );
    }
}
