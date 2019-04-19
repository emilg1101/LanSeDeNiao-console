package com.github.emilg1101.lansedeniao.domain.repository;

import com.github.emilg1101.lansedeniao.domain.entity.User;

public interface UserRepository {

    User getUserById(long id);

    User getUserByUsername(String username);

    User addUser(User user);

    boolean hasLoggedInUser();

    User getLoggedInUser();

    void setLoggedInUser(User user);
}
