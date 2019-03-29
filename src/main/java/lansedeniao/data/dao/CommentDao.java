package lansedeniao.data.dao;

import lansedeniao.data.entity.CommentDto;

import java.util.List;
import java.util.Optional;

public interface CommentDao {

    Optional<CommentDto> getComment(long commentId);

    Optional<List<CommentDto>> getCommentByPostId(long postId);

    Optional<CommentDto> addComment(long postId, long userId, String text);
}
