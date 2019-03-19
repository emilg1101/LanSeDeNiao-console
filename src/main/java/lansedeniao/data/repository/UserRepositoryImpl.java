package lansedeniao.data.repository;

import lansedeniao.data.UserDao;
import lansedeniao.data.db.UserDaoImpl;
import lansedeniao.data.mapper.UserMapper;
import lansedeniao.domain.entity.User;
import lansedeniao.domain.repository.UserRepository;

import java.time.Instant;
import java.util.Date;

public class UserRepositoryImpl implements UserRepository {

    private static UserRepository instance = null;

    private UserDao userDao = new UserDaoImpl();

    private User loggedInUser;

    private UserRepositoryImpl() {

    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    @Override
    public User getUserById(long id) {
        return new UserMapper().map(userDao.getUserById(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return new User(0, username, "123", "", "", Date.from(Instant.now()), Date.from(Instant.now()), "", 2, 0, 0);
    }

    @Override
    public User addUser(User user) {
        return user;
    }

    @Override
    public boolean hasLoggedInUser() {
        return loggedInUser != null;
    }

    @Override
    public User getLoggedInUser() {
        return loggedInUser;
    }

    @Override
    public void setLoggedInUser(User user) {
        loggedInUser = user;
    }
}
