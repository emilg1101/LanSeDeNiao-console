package lansedeniao.data.dao.db;

import lansedeniao.data.dao.PostDao;
import lansedeniao.data.entity.PostDto;
import lansedeniao.data.mapper.PostRowMapper;
import lansedeniao.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostDaoImpl implements PostDao {

    private Connection connection = DbUtil.getConnection();

    @Override
    public Optional<PostDto> getPostById(long id) {
        try {
            String insertTableSQL = "SELECT *, (SELECT count(id) FROM new_schema.like WHERE post_id = post.id) AS likes_amount FROM new_schema.post WHERE id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new PostRowMapper().rowMap(resultSet);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<PostDto>> getPostsByUserId(long userId) {
        List<PostDto> postDtoList = new ArrayList<>();
        try {
            String insertTableSQL = "SELECT *, (SELECT count(id) FROM new_schema.like WHERE post_id = post.id) AS likes_amount FROM new_schema.post WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                postDtoList.add(new PostRowMapper().rowMap(resultSet).get());
            }
            return Optional.of(postDtoList);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<PostDto> addPost(long userId, String text) {
        try {
            String insertSQL = "INSERT INTO new_schema.post (user_id, text) VALUES (?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, userId);
            preparedStatement.setString(2, text);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return getPostById(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
