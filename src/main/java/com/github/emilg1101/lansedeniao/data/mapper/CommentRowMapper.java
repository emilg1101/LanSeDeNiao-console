package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.RowMapper;
import com.github.emilg1101.lansedeniao.data.entity.CommentDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class CommentRowMapper implements RowMapper<CommentDto> {

    @Override
    public Optional<CommentDto> rowMap(ResultSet resultSet) throws SQLException {
        CommentDto commentDto = new CommentDto();
        commentDto.id = resultSet.getLong("id");
        commentDto.postId = resultSet.getLong("post_id");
        commentDto.userId = resultSet.getLong("user_id");
        commentDto.text = resultSet.getString("text");
        commentDto.username = resultSet.getString("username");
        return Optional.of(commentDto);
    }
}
