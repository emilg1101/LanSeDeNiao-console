package lansedeniao.data.mapper;

import lansedeniao.data.base.Mapper;
import lansedeniao.data.entity.CommentDto;
import lansedeniao.domain.entity.Comment;

public class CommentMapper implements Mapper<CommentDto, Comment> {

    @Override
    public Comment map(CommentDto commentDto) {
        return new Comment(commentDto.username, commentDto.text);
    }
}
