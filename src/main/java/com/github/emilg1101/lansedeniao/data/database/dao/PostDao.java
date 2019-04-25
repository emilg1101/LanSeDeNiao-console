package com.github.emilg1101.lansedeniao.data.database.dao;

import com.github.emilg1101.lansedeniao.data.database.dto.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    Optional<PostDto> getPostById(long id);

    Optional<List<PostDto>> getPostsByUserId(long userId);

    Optional<PostDto> addPost(long userId, String text);
}
