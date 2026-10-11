package org.social.posts.entity.dto.request;

import org.social.posts.entity.Post;

import java.time.LocalDateTime;

public class UpdatePostRequest {
    private final int likes;
    private final int dislikes;
    private final int comments;
    private final String title;

    public UpdatePostRequest(int likes, int dislikes, int comments, String title) {
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.title = title;
    }
    public Post toEntity(int id, LocalDateTime date, String author) {
        return new Post(
            id, author, date,  likes, dislikes, comments, title
        );
    }
}
