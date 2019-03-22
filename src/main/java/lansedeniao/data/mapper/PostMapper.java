package lansedeniao.data.mapper;

import lansedeniao.data.base.BiMapper;
import lansedeniao.data.entity.PostDto;
import lansedeniao.data.entity.UserDto;
import lansedeniao.domain.entity.Post;

public class PostMapper implements BiMapper<PostDto, UserDto, Post> {

    @Override
    public Post map(PostDto postDto, UserDto userDto) {
        return new Post(postDto.id, postDto.text, postDto.cdate, postDto.likesAmount, postDto.userId, userDto.username);
    }
}
