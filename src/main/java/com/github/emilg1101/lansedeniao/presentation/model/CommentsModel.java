package com.github.emilg1101.lansedeniao.presentation.model;

import com.github.emilg1101.lansedeniao.domain.entity.Comment;

import java.util.List;
import java.util.stream.Collectors;

public class CommentsModel {

    private List<CommentModel> commentModelList;

    private CommentsModel(List<CommentModel> commentModels) {
        this.commentModelList = commentModels;
    }

    public List<CommentModel> getCommentModelList() {
        return commentModelList;
    }

    public static CommentsModel mapper(List<Comment> comments) {
        return new CommentsModel(comments.stream().map(CommentModel::mapper).collect(Collectors.toList()));
    }
}
