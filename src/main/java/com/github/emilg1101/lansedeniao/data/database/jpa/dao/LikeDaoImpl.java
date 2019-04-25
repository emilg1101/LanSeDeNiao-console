package com.github.emilg1101.lansedeniao.data.database.jpa.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.LikeDao;
import com.github.emilg1101.lansedeniao.data.database.dto.LikeDto;
import com.github.emilg1101.lansedeniao.data.database.jpa.JpaQualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component("JpaLikeDao")
@JpaQualifier
public class LikeDaoImpl implements LikeDao {

    @Override
    public Optional<LikeDto> setLike(long postId, long userId) {
        return Optional.empty();
    }

    @Override
    public boolean removeLike(long postId, long userId) {
        return false;
    }

    @Override
    public boolean isLiked(long postId, long userId) {
        return false;
    }
}
