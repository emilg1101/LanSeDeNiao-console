package lansedeniao.domain.usecase;

import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.UserRepository;

public class LogoutUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();

    public void logout() throws UserNotLoggedInException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        userRepository.setLoggedInUser(null);
    }
}
