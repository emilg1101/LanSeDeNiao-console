package domain.usecase;

import data.repository.UserRepositoryImpl;
import domain.entity.User;
import domain.exception.AuthException;
import domain.exception.UserNotFoundException;
import domain.repository.UserRepository;

public class LoginUseCase {

    private UserRepository userRepository = new UserRepositoryImpl();

    public User login(String username, String password) throws UserNotFoundException, AuthException {
        User user = userRepository.getUserByUsername(username);
        if (user == null) {
            throw new UserNotFoundException();
        }
        if (!user.getPassword().equals(password)) {
            throw new AuthException();
        }
        return user;
    }
}
