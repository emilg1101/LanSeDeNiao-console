package com.github.emilg1101.lansedeniao.data.database.jpa.mapper;

import com.github.emilg1101.lansedeniao.data.base.TwoWayMapper;
import com.github.emilg1101.lansedeniao.data.database.dto.UserDto;
import com.github.emilg1101.lansedeniao.data.database.jpa.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements TwoWayMapper<User, UserDto> {

    @Override
    public UserDto mapTo(User from) {
        UserDto userDto = new UserDto();
        userDto.id = from.id;
        userDto.username = from.username;
        userDto.password = from.password;
        userDto.name = from.name;
        userDto.email = from.email;
        userDto.bdate = from.bdate;
        userDto.country = from.country;
        userDto.gender = from.gender;
        userDto.rdate = from.rdate;
        userDto.likesAmount = from.likesAmount;
        userDto.postsAmount = from.postsAmount;
        return userDto;
    }

    @Override
    public User mapFrom(UserDto from) {
        User user = new User();
        user.id = from.id;
        user.username = from.username;
        user.password = from.password;
        user.name = from.name;
        user.email = from.email;
        user.bdate = from.bdate;
        user.country = from.country;
        user.gender = from.gender;
        user.rdate = from.rdate;
        user.likesAmount = from.likesAmount;
        user.postsAmount = from.postsAmount;
        return user;
    }
}
