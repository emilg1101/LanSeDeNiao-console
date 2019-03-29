package lansedeniao.data.mapper;

import lansedeniao.data.base.Mapper3;
import lansedeniao.data.entity.CommentDto;
import lansedeniao.data.entity.PostDto;
import lansedeniao.data.entity.UserDto;
import lansedeniao.domain.entity.Post;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper implements Mapper3<PostDto, UserDto, List<CommentDto>, Post> {

    @Override
    public Post map(PostDto postDto, UserDto userDto, List<CommentDto> commentDtoList) {
        return new Post(
                postDto.id,
                postDto.text,
                postDto.cdate,
                postDto.likesAmount,
                postDto.userId,
                userDto.username,
                commentDtoList.stream()
                        .map(comment -> new CommentMapper().map(comment))
                        .collect(Collectors.toList())
        );
    }
}
