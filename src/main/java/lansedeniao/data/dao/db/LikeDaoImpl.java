package lansedeniao.data.dao.db;

import lansedeniao.data.dao.LikeDao;
import lansedeniao.data.entity.LikeDto;

import java.util.Optional;

public class LikeDaoImpl implements LikeDao {

    @Override
    public Optional<LikeDto> setLike(long postId, long userId) {
        return Optional.empty();
    }

    @Override
    public boolean isLiked(long postId, long userId) {
        return false;
    }
}
