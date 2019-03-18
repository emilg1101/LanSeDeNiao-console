package lansedeniao.domain.usecase;

import lansedeniao.data.repository.UserRepositoryImpl;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.repository.UserRepository;

public class LogoutUseCase {

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    public void logout() throws UserNotLoggedInException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        userRepository.setLoggedInUser(null);
    }
}
