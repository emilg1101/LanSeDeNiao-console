package lansedeniao.data;

import lansedeniao.data.entity.UserDto;

public interface UserDao {

    UserDto getUserById(long id);
}
