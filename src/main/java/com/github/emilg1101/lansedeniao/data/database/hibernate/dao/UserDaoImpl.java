package com.github.emilg1101.lansedeniao.data.database.hibernate.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.UserDao;
import com.github.emilg1101.lansedeniao.data.database.dto.UserDto;

import java.util.Optional;

public class UserDaoImpl implements UserDao {

    @Override
    public Optional<UserDto> getUserById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public Optional<UserDto> addUser(UserDto userDto) {
        return Optional.empty();
    }
}
