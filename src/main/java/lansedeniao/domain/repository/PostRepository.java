package lansedeniao.domain.repository;

import lansedeniao.domain.entity.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getPostsByUserId(long userId);

    Post addPost(long userId, String text);

    boolean setLike(long userId, long postId);
}
