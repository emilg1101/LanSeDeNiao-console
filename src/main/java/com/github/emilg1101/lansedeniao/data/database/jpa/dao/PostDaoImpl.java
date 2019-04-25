package com.github.emilg1101.lansedeniao.data.database.jpa.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.PostDao;
import com.github.emilg1101.lansedeniao.data.database.dto.PostDto;
import com.github.emilg1101.lansedeniao.data.database.jpa.JpaQualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("JpaPostDao")
@JpaQualifier
public class PostDaoImpl implements PostDao {

    @Override
    public Optional<PostDto> getPostById(long id) {
        return Optional.empty();
    }

    @Override
    public Optional<List<PostDto>> getPostsByUserId(long userId) {
        return Optional.empty();
    }

    @Override
    public Optional<PostDto> addPost(long userId, String text) {
        return Optional.empty();
    }
}
