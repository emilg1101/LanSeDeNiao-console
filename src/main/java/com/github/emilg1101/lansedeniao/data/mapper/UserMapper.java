package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.Mapper;
import com.github.emilg1101.lansedeniao.data.entity.UserDto;
import com.github.emilg1101.lansedeniao.domain.entity.User;

public class UserMapper implements Mapper<UserDto, User> {

    @Override
    public User map(UserDto from) {
        return new User(
                from.id,
                from.username,
                from.password,
                from.name,
                from.email,
                from.rdate,
                from.bdate,
                from.country,
                from.gender,
                from.likesAmount,
                from.postsAmount
        );
    }
}
