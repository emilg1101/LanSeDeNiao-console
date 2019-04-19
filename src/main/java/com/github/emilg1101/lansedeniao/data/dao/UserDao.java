package com.github.emilg1101.lansedeniao.data.dao;

import com.github.emilg1101.lansedeniao.data.entity.UserDto;

import java.util.Optional;

public interface UserDao {

    Optional<UserDto> getUserById(long id);

    Optional<UserDto> getUserByUsername(String username);

    Optional<UserDto> addUser(UserDto userDto);
}
