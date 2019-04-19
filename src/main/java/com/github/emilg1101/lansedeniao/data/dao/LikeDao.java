package com.github.emilg1101.lansedeniao.data.dao;

import com.github.emilg1101.lansedeniao.data.entity.LikeDto;

import java.util.Optional;

public interface LikeDao {

    Optional<LikeDto> setLike(long postId, long userId);

    boolean removeLike(long postId, long userId);

    boolean isLiked(long postId, long userId);
}
