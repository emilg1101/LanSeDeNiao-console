package lansedeniao.data.repository;

import lansedeniao.data.UserDao;
import lansedeniao.data.db.UserDaoImpl;
import lansedeniao.domain.entity.User;
import lansedeniao.domain.repository.UserRepository;

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
        return User.mapper(userDao.getUserById(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return new User(username, "123");
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
