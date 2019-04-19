package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.Mapper;
import com.github.emilg1101.lansedeniao.data.entity.CommentDto;
import com.github.emilg1101.lansedeniao.domain.entity.Comment;

public class CommentMapper implements Mapper<CommentDto, Comment> {

    @Override
    public Comment map(CommentDto commentDto) {
        return new Comment(commentDto.username, commentDto.text);
    }
}
