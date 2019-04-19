package com.github.emilg1101.lansedeniao.presentation.model;

import com.github.emilg1101.lansedeniao.domain.entity.Comment;

public class CommentModel {

    private String username;
    private String text;

    private CommentModel(String username, String text) {
        this.username = username;
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public String getText() {
        return text;
    }

    public static CommentModel mapper(Comment comment) {
        return new CommentModel(comment.getUsername(), comment.getText());
    }
}
