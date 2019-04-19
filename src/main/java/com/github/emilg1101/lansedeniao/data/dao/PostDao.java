package com.github.emilg1101.lansedeniao.data.dao;

import com.github.emilg1101.lansedeniao.data.entity.PostDto;

import java.util.List;
import java.util.Optional;

public interface PostDao {

    Optional<PostDto> getPostById(long id);

    Optional<List<PostDto>> getPostsByUserId(long userId);

    Optional<PostDto> addPost(long userId, String text);
}
