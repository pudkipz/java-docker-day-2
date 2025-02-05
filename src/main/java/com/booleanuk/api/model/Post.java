package com.booleanuk.api.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne @JoinColumn
    @JsonIncludeProperties({"id", "username"})
    private User user;

    @Column
    private String body;

    @ManyToOne
    private Post originalPost;

    @Column
    private LocalDateTime timestamp;

    @JsonIgnore
    @ManyToMany
    private Set<User> upvotes;

    public Post(User user, String body, Post originalPost) {
        this.user = user;
        this.body = body;
        this.originalPost = originalPost;
    }

    public Post() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public Set<User> getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Set<User> upvotes) {
        this.upvotes = upvotes;
    }

    public Post getOriginalPost() {
        return originalPost;
    }

    public void setOriginalPost(Post originalPost) {
        this.originalPost = originalPost;
    }
}
