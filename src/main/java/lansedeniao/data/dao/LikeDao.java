package lansedeniao.data.dao;

import lansedeniao.data.entity.LikeDto;

import java.util.Optional;

public interface LikeDao {

    Optional<LikeDto> setLike(long postId, long userId);

    boolean removeLike(long postId, long userId);

    boolean isLiked(long postId, long userId);
}
