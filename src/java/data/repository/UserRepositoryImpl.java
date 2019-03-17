package data.repository;

import data.UserDao;
import data.db.UserDaoImpl;
import domain.entity.User;
import domain.repository.UserRepository;

public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao = new UserDaoImpl();

    @Override
    public User getUserById(long id) {
        return User.mapper(userDao.getUserById(id));
    }

    @Override
    public User getUserByUsername(String username) {
        return new User(username, "123");
    }
}
