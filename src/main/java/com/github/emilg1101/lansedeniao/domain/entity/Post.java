package com.github.emilg1101.lansedeniao.domain.entity;

import java.util.Date;
import java.util.List;

public class Post {

    private long id;
    private String text;
    private Date cdate;
    private int likesAmount;
    private long userId;
    private String username;
    private List<Comment> comments;

    public Post(long id, String text, Date cdate, int likesAmount, long userId, String username, List<Comment> comments) {
        this.id = id;
        this.text = text;
        this.cdate = cdate;
        this.likesAmount = likesAmount;
        this.userId = userId;
        this.username = username;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public Date getCdate() {
        return cdate;
    }

    public int getLikesAmount() {
        return likesAmount;
    }

    public long getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
