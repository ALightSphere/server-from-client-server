package org.social.posts.entity.dto;

import java.time.LocalDateTime;

public class PostDto {
    private final int id;
    private final String title;
    private final String author;
    private final int likes;
    private final int dislikes;
    private final int comments;
    private final LocalDateTime date;

    public PostDto(int id, String title, String author, int likes, int dislikes, int comments, LocalDateTime date){
        this.id = id;
        this.title = title;
        this.author = author;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.date = date;
    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getLikes() {
        return likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public int getComments() {
        return comments;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
