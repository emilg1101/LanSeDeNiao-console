package com.github.emilg1101.lansedeniao.data.database.jdbc.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.LikeDao;
import com.github.emilg1101.lansedeniao.data.database.dto.LikeDto;
import com.github.emilg1101.lansedeniao.data.database.jdbc.JdbcQualifier;
import com.github.emilg1101.lansedeniao.data.mapper.LikeRowMapper;
import com.github.emilg1101.lansedeniao.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

@Component("JdbcLikeDao")
@JdbcQualifier
public class LikeDaoImpl implements LikeDao {

    private Connection connection = DbUtil.getConnection();

    @Override
    public Optional<LikeDto> setLike(long postId, long userId) {
        try {
            String insertSQl = "INSERT INTO new_schema.like (user_id, post_id) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQl);
            preparedStatement.setLong(1, userId);
            preparedStatement.setLong(2, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new LikeRowMapper().rowMap(resultSet);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean removeLike(long postId, long userId) {
        try {
            String removeSQL = "DELETE FROM new_schema.\"like\" WHERE post_id = ? AND user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(removeSQL);
            preparedStatement.setLong(1, postId);
            preparedStatement.setLong(2, userId);
            return preparedStatement.execute();
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public boolean isLiked(long postId, long userId) {
        try {
            String checkSQL = "SELECT EXISTS(SELECT * FROM new_schema.\"like\" WHERE post_id = ? AND user_id = ?) AS is_liked";
            PreparedStatement preparedStatement = connection.prepareStatement(checkSQL);
            preparedStatement.setLong(1, postId);
            preparedStatement.setLong(2, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getBoolean("is_liked");
        } catch (SQLException e) {
            return false;
        }
    }
}
