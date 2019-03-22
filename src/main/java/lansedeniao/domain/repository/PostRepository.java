package lansedeniao.domain.repository;

import lansedeniao.domain.entity.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getPostsByUserId(long userId);

    boolean setLike(long userId, long postId);
}
