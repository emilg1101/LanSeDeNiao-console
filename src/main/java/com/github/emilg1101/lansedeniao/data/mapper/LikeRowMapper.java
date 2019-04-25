package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.RowMapper;
import com.github.emilg1101.lansedeniao.data.database.dto.LikeDto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class LikeRowMapper implements RowMapper<LikeDto> {

    @Override
    public Optional<LikeDto> rowMap(ResultSet resultSet) throws SQLException {
        LikeDto likeDto = new LikeDto();
        likeDto.id = resultSet.getLong("id");
        return Optional.of(likeDto);
    }
}
