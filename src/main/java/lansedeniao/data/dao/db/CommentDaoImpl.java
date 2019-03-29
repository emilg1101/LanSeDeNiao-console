package lansedeniao.data.dao.db;

import lansedeniao.data.dao.CommentDao;
import lansedeniao.data.entity.CommentDto;
import lansedeniao.data.mapper.CommentRowMapper;
import lansedeniao.util.DbUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CommentDaoImpl implements CommentDao {

    private Connection connection = DbUtil.getConnection();

    @Override
    public Optional<CommentDto> getComment(long commentId) {
        try {
            String selectSQL = "SELECT \"comment\".*, \"user\".username FROM new_schema.comment INNER JOIN new_schema.\"user\" ON comment.user_id = \"user\".id WHERE comment.id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, commentId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return new CommentRowMapper().rowMap(resultSet);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<List<CommentDto>> getCommentByPostId(long postId) {
        List<CommentDto> commentDtoList = new ArrayList<>();
        try {
            String selectSQL = "SELECT \"comment\".*, \"user\".username FROM new_schema.comment INNER JOIN new_schema.\"user\" ON comment.user_id = \"user\".id WHERE post_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(selectSQL);
            preparedStatement.setLong(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                commentDtoList.add(new CommentRowMapper().rowMap(resultSet).get());
            }
            return Optional.of(commentDtoList);
        } catch (SQLException e) {
            return Optional.empty();
        }
    }

    @Override
    public Optional<CommentDto> addComment(long postId, long userId, String text) {
        try {
            String insertSQL = "INSERT INTO new_schema.comment (post_id, user_id, text) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertSQL, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setLong(1, postId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setString(3, text);

            int affectedRows = preparedStatement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException();
            }

            try (ResultSet generatedKeys = preparedStatement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return getComment(generatedKeys.getLong(1));
                } else {
                    throw new SQLException("no ID obtained");
                }
            }

        } catch (SQLException e) {
            return Optional.empty();
        }
    }
}
