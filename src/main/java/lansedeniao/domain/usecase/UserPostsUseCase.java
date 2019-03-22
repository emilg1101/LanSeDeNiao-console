package lansedeniao.domain.usecase;

import lansedeniao.domain.entity.Post;
import lansedeniao.domain.factory.RepositoryFactory;
import lansedeniao.domain.repository.PostRepository;

import java.util.List;

public class UserPostsUseCase {

    private PostRepository postRepository = RepositoryFactory.getPostRepository();

    public List<Post> getPosts(long userId) {
        return postRepository.getPostsByUserId(userId);
    }
}
