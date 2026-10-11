package org.social.posts.entity;

import jakarta.persistence.*;
import org.social.posts.entity.dto.PostDto;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="author", nullable=false, length=30)
    private String author;
    @Column(name="date", nullable=false)
    private LocalDateTime date;
    @Column(name="number_of_likes", nullable=false)
    private int likes;
    @Column(name="number_of_dislikes", nullable=false)
    private int dislikes;
    @Column(name="number_of_comments", nullable=false)
    private int comments;
    @Column(name="title", nullable=false, length = 100)
    private String title;

    public Post() {}

    public Post(int id, String author, LocalDateTime date, int likes, int dislikes, int comments, String title) {
        this.id = id;
        this.author = author;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.title = title;
    }

    public Post(String author, LocalDateTime date, int likes, int dislikes, int comments, String title) {
        this.author = author;
        this.date = date;
        this.likes = likes;
        this.dislikes = dislikes;
        this.comments = comments;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getDislikes() {
        return dislikes;
    }

    public void setDislikes(int dislikes) {
        this.dislikes = dislikes;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public PostDto toDto(){
         return new PostDto(id, title, author, likes, dislikes, comments, date);
    }
}
