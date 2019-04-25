package lansedeniao.data.database.dao;

import lansedeniao.data.database.dto.UserDto;

import java.util.Optional;

public interface UserDao {

    Optional<UserDto> getUserById(long id);

    Optional<UserDto> getUserByUsername(String username);

    Optional<UserDto> addUser(UserDto userDto);
}
