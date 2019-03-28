package lansedeniao.data.dao;

import lansedeniao.data.entity.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    Optional<PostDto> getPostById(long id);

    Optional<List<PostDto>> getPostsByUserId(long userId);

    Optional<PostDto> getPost(long id);

    Optional<PostDto> addPost(long userId, String text);
}
