package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetProfileUseCase {

    @Autowired
    private UserRepository userRepository;

    public User getProfile(String username) throws UserNotFoundException, UserNotLoggedInException {
        User user;
        if (username == null || username.equals("")) {
            if (!userRepository.hasLoggedInUser()) throw new UserNotLoggedInException();
            user = userRepository.getLoggedInUser();
        } else {
            user = userRepository.getUserByUsername(username);
        }
        if (user == null) {
            throw new UserNotFoundException();
        }
        return user;
    }
}
