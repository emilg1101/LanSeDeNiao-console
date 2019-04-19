package com.github.emilg1101.lansedeniao.data.repository;

import com.github.emilg1101.lansedeniao.data.dao.UserDao;
import com.github.emilg1101.lansedeniao.data.entity.UserDto;
import com.github.emilg1101.lansedeniao.data.mapper.UserMapper;
import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserDao userDao;

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
