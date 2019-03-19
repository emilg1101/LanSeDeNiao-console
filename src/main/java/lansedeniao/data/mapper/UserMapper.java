package lansedeniao.data.mapper;

import lansedeniao.data.entity.UserDto;
import lansedeniao.domain.entity.User;

import java.time.Instant;
import java.util.Date;

public class UserMapper implements Mapper<UserDto, User> {
    @Override
    public User map(UserDto userDto) {
        return new User(0, "username", "password", "", "", Date.from(Instant.now()), Date.from(Instant.now()), "", 2, 0, 0);
    }
}
