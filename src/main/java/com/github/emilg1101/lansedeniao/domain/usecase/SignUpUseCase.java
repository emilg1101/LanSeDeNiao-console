package com.github.emilg1101.lansedeniao.domain.usecase;

import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.*;
import com.github.emilg1101.lansedeniao.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Date;

@Component
public class SignUpUseCase {

    @Autowired
    private UserRepository userRepository;

    public void signup(String name, String email, String username, String password) throws UsernameExistsException,
            NameValidationException, EmailValidationException, UsernameValidationException,
            PasswordValidationException {
        if (userRepository.getUserByUsername(username) != null) {
            throw new UsernameExistsException();
        }
        if (name.isEmpty() || name.length() <= 3) {
            throw new NameValidationException();
        }
        if (email.isEmpty() || email.length() <= 3) {
            throw new EmailValidationException();
        }
        if (username.isEmpty() || username.length() <= 3) {
            throw new UsernameValidationException();
        }
        if (password.isEmpty() || password.length() <= 3) {
            throw new PasswordValidationException();
        }

        User user = new User(0, username, password, name, email, Date.from(Instant.now()), null, "", 2, 0, 0);
        user = userRepository.addUser(user);
        userRepository.setLoggedInUser(user);
    }
}
