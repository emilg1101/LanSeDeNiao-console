package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.AuthException;
import com.github.emilg1101.lansedeniao.domain.exception.UserLoggedInException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUseCase {

    @Autowired
    private UserRepository userRepository;

    public User login(String username, String password) throws UserNotFoundException, AuthException, UserLoggedInException {
        if (userRepository.hasLoggedInUser()) {
            throw new UserLoggedInException();
        }
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthException();
        }
        userRepository.setLoggedInUser(user);
        return user;
    }
}
