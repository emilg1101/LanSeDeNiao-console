package com.github.emilg1101.lansedeniao.domain.repository;

import com.github.emilg1101.lansedeniao.domain.entity.Comment;
import com.github.emilg1101.lansedeniao.domain.entity.Post;

import java.util.List;

public interface PostRepository {

    List<Post> getPostsByUserId(long userId);

    Post addPost(long userId, String text);

    boolean setLike(long postId, long userId);

    Comment addComment(long postId, long userId, String text);
}
