package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.Post;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

import java.util.List;

public class UserPostsUseCase {

    private PostRepository postRepository = RepositoryFactory.getPostRepository();
    private UserRepository userRepository = RepositoryFactory.getUserRepository();

    public List<Post> getPosts(long userId) throws UserNotFoundException {
        if (userRepository.getUserById(userId) == null) throw new UserNotFoundException();
        return postRepository.getPostsByUserId(userId);
    }
}
