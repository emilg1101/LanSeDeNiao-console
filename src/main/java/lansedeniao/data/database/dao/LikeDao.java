package lansedeniao.data.database.dao;

import lansedeniao.data.database.dto.LikeDto;

import java.util.Optional;

public interface LikeDao {

    Optional<LikeDto> setLike(long postId, long userId);

    boolean removeLike(long postId, long userId);

    boolean isLiked(long postId, long userId);
}
