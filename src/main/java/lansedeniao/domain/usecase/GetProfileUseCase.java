package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.UserRepository;

public class GetProfileUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();

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
