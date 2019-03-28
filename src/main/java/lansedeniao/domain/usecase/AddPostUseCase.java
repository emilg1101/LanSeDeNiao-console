package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.Post;
import lansedeniao.domain.exception.AddPostException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

public class AddPostUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();
    private PostRepository postRepository = RepositoryFactory.getPostRepository();

    public Post addPost(String text) throws UserNotLoggedInException, AddPostException {
        if (!userRepository.hasLoggedInUser()) {
            throw new UserNotLoggedInException();
        }
        Post addedPost = postRepository.addPost(userRepository.getLoggedInUser().getId(), text);
        if (addedPost == null) {
            throw new AddPostException();
        }
        return addedPost;
    }
}
