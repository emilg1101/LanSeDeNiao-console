package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.RowMapper;
import com.github.emilg1101.lansedeniao.data.database.dto.UserDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class UserRowMapper implements RowMapper<UserDto> {

    @Override
    public Optional<UserDto> rowMap(ResultSet resultSet) throws SQLException {
        resultSet.next();
        UserDto userDto = new UserDto();
        userDto.id = resultSet.getLong("id");
        userDto.username = resultSet.getString("username");
        userDto.password = resultSet.getString("password");
        userDto.name = resultSet.getString("name");
        userDto.email = resultSet.getString("email");
        userDto.bdate = resultSet.getDate("bdate");
        userDto.country = resultSet.getString("country");
        userDto.gender = resultSet.getInt("gender");
        userDto.rdate = resultSet.getDate("rdate");
        userDto.postsAmount = resultSet.getInt("posts_amount");
        userDto.likesAmount = resultSet.getInt("likes_amount");
        return Optional.of(userDto);
    }
}
