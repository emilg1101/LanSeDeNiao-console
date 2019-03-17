package data;

import data.entity.UserDto;

public interface UserDao {

    UserDto getUserById(long id);
}
