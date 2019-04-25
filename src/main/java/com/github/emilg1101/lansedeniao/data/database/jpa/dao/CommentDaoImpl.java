package com.github.emilg1101.lansedeniao.data.database.jpa.dao;

import com.github.emilg1101.lansedeniao.data.database.dao.CommentDao;
import com.github.emilg1101.lansedeniao.data.database.dto.CommentDto;
import com.github.emilg1101.lansedeniao.data.database.jpa.JpaQualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component("JpaCommentDao")
@JpaQualifier
public class CommentDaoImpl implements CommentDao {

    @Override
    public Optional<CommentDto> getComment(long commentId) {
        return Optional.empty();
    }

    @Override
    public Optional<List<CommentDto>> getCommentByPostId(long postId) {
        return Optional.empty();
    }

    @Override
    public Optional<CommentDto> addComment(long postId, long userId, String text) {
        return Optional.empty();
    }
}
