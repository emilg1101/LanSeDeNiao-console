package lansedeniao.data.db;

import lansedeniao.data.UserDao;
import lansedeniao.data.entity.UserDto;

public class UserDaoImpl implements UserDao {

    @Override
    public UserDto getUserById(long id) {
        return new UserDto();
    }
}
