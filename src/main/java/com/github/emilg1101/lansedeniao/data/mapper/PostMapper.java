package com.github.emilg1101.lansedeniao.data.mapper;

import com.github.emilg1101.lansedeniao.data.base.Mapper3;
import com.github.emilg1101.lansedeniao.data.database.dto.CommentDto;
import com.github.emilg1101.lansedeniao.data.database.dto.PostDto;
import com.github.emilg1101.lansedeniao.data.database.dto.UserDto;
import com.github.emilg1101.lansedeniao.domain.entity.Post;

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
