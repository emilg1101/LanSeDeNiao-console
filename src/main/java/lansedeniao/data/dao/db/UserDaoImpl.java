package lansedeniao.data.dao.db;

import lansedeniao.data.dao.UserDao;
import lansedeniao.data.entity.UserDto;
import lansedeniao.data.mapper.UserRowMapper;
import lansedeniao.util.DbUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

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
}
