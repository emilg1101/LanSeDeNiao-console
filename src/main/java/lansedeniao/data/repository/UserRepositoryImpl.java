package lansedeniao.data.repository;

import lansedeniao.data.dao.provider.DaoProvider;
import lansedeniao.data.dao.UserDao;
import lansedeniao.data.entity.UserDto;
import lansedeniao.data.mapper.UserMapper;
import lansedeniao.domain.entity.User;
import lansedeniao.domain.repository.UserRepository;

import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private UserDao userDao = DaoProvider.provideUserDao();

    private User loggedInUser;

    @Override
    public User getUserById(long id) {
        Optional<UserDto> userDto = userDao.getUserById(id);
        if (userDto.isPresent()) {
            return new UserMapper().map(userDto.get());
        }
        return null;
    }

    @Override
    public User getUserByUsername(String username) {
        Optional<UserDto> userDto = userDao.getUserByUsername(username);
        if (userDto.isPresent()) {
            return new UserMapper().map(userDto.get());
        }
        return null;
    }

    @Override
    public User addUser(User user) {
        UserDto userDto = new UserDto();
        userDto.username = user.getUsername();
        userDto.email = user.getEmail();
        userDto.password = user.getPassword();
        userDto.name = user.getName();
        Optional<UserDto> userDtoOptional = userDao.addUser(userDto);
        if (userDtoOptional.isPresent()) {
            return new UserMapper().map(userDtoOptional.get());
        }
        return null;
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
