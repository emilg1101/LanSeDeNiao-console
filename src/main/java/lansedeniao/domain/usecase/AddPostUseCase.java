package lansedeniao.domain.usecase;

import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

public class AddPostUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();
    private PostRepository postRepository = RepositoryFactory.getPostRepository();

    public void addPost(String text) throws UserNotLoggedInException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        postRepository.addPost(userRepository.getLoggedInUser().getId(), text);
    }
}
