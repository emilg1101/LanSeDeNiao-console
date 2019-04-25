package com.github.emilg1101.lansedeniao.data.database.jpa.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.UserDao;
import com.github.emilg1101.lansedeniao.data.database.dto.UserDto;
import com.github.emilg1101.lansedeniao.data.database.jpa.JpaQualifier;
import com.github.emilg1101.lansedeniao.data.database.jpa.mapper.UserMapper;
import com.github.emilg1101.lansedeniao.data.database.jpa.repository.UserJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("JpaUserDao")
@JpaQualifier
public class UserDaoImpl implements UserDao {

    @Autowired
    private UserJpaRepository userJpaRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public Optional<UserDto> getUserById(long id) {
        return userJpaRepository.getUserById(id).map(userMapper::mapTo);
    }

    @Override
    public Optional<UserDto> getUserByUsername(String username) {
        return userJpaRepository.getUserByUsername(username).map(userMapper::mapTo);
    }

    @Override
    public Optional<UserDto> addUser(UserDto userDto) {
        return Optional.of(userJpaRepository.save(userMapper.mapFrom(userDto))).map(userMapper::mapTo);
    }
}
