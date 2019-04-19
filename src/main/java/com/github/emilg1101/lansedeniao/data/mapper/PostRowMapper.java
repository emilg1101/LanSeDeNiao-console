package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.RowMapper;
import com.github.emilg1101.lansedeniao.data.entity.PostDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class PostRowMapper implements RowMapper<PostDto> {
    @Override
    public Optional<PostDto> rowMap(ResultSet resultSet) throws SQLException {
        PostDto postDto = new PostDto();
        postDto.id = resultSet.getLong("id");
        postDto.userId = resultSet.getLong("user_id");
        postDto.text = resultSet.getString("text");
        postDto.cdate = resultSet.getDate("cdate");
        postDto.likesAmount = resultSet.getInt("likes_amount");
        return Optional.of(postDto);
    }
}
