package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.*;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.UserRepository;

import java.time.Instant;
import java.util.Date;

public class SignUpUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();

    public void signup(String name, String email, String username, String password) throws UsernameExistsException,
            NameValidationException, EmailValidationException, UsernameValidationException,
            PasswordValidationException {
        if (userRepository.getUserByUsername(username) != null) {
            throw new UsernameExistsException();
        }
        if (name.isEmpty() || name.length() < 3) {
            throw new NameValidationException();
        }
        if (email.isEmpty() || email.length() < 3) {
            throw new EmailValidationException();
        }
        if (username.isEmpty() || username.length() < 3) {
            throw new UsernameValidationException();
        }
        if (password.isEmpty() || username.length() < 6) {
            throw new PasswordValidationException();
        }

        User user = new User(0, username, password, name, email, Date.from(Instant.now()), null, "", 2, 0, 0);
        user = userRepository.addUser(user);
        userRepository.addUser(user);
    }
}
