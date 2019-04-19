package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutUseCase {

    @Autowired
    private UserRepository userRepository;

    public void logout() throws UserNotLoggedInException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        userRepository.setLoggedInUser(null);
    }
}
