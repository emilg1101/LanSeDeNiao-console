package com.github.emilg1101.lansedeniao.data.dao.db;

import com.github.emilg1101.lansedeniao.data.dao.UserDao;
import com.github.emilg1101.lansedeniao.data.entity.UserDto;
import com.github.emilg1101.lansedeniao.data.mapper.UserRowMapper;
import com.github.emilg1101.lansedeniao.util.DbUtil;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.Optional;

@Component
public class UserDaoImpl implements UserDao {

    private Connection connection = DbUtil.getConnection();

    @Override
    public Optional<UserDto> getUserById(long id) {
        try {
            String insertTableSQL = "SELECT *, (SELECT count(id) FROM new_schema.post WHERE user_id = new_schema.user.id) AS posts_amount,\n" +
                    "          (SELECT count(post.id) FROM new_schema.post INNER JOIN new_schema.like ON post.id = new_schema.like.post_id AND post.user_id = new_schema.user.id) AS likes_amount\n" +
                    "FROM new_schema.user\n" +
                    "WHERE new_schema.user.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setLong(1, id);
            return new UserRowMapper().rowMap(preparedStatement.executeQuery());
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        try {
            String insertTableSQL = "SELECT *, (SELECT count(id) FROM new_schema.post WHERE user_id = new_schema.user.id) AS posts_amount,\n" +
                    "          (SELECT count(post.id) FROM new_schema.post INNER JOIN new_schema.like ON post.id = new_schema.like.post_id AND post.user_id = new_schema.user.id) AS likes_amount\n" +
                    "FROM new_schema.user\n" +
                    "WHERE new_schema.user.username = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setString(1, username);
            return new UserRowMapper().rowMap(preparedStatement.executeQuery());
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<UserDto> addUser(UserDto userDto) {
        try {
            String insertSQL = "INSERT INTO new_schema.user (username, password, email, name) VALUES (?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, userDto.username);
            preparedStatement.setString(2, userDto.password);
            preparedStatement.setString(3, userDto.email);
            preparedStatement.setString(4, userDto.name);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return getUserById(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
