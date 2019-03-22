package lansedeniao.data.dao;

import lansedeniao.data.entity.UserDto;

import java.util.Optional;

public interface UserDao {

    Optional<UserDto> getUserById(long id);

    Optional<UserDto> getUserByUsername(String username);
}
