package lansedeniao.data.dao.db;

import javafx.geometry.Pos;
import lansedeniao.data.dao.PostDao;
import lansedeniao.data.entity.PostDto;
import lansedeniao.data.mapper.PostRowMapper;
import lansedeniao.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
