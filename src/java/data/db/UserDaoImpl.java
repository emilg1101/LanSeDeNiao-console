package data.db;

import data.UserDao;
import data.entity.UserDto;

public class UserDaoImpl implements UserDao {

    @Override
    public UserDto getUserById(long id) {
        return new UserDto();
    }
}
