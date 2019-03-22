package lansedeniao.domain.usecase;

import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;
import lansedeniao.domain.repository.UserRepository;

public class LikePostUseCase {

    private UserRepository userRepository = RepositoryFactory.getUserRepository();
    private PostRepository postRepository = RepositoryFactory.getPostRepository();

    public void like(long postId) {

    }
}
