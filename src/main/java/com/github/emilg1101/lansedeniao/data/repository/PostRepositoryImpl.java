package com.github.emilg1101.lansedeniao.data.repository;

import com.github.emilg1101.lansedeniao.data.dao.CommentDao;
import com.github.emilg1101.lansedeniao.data.dao.LikeDao;
import com.github.emilg1101.lansedeniao.data.dao.PostDao;
import com.github.emilg1101.lansedeniao.data.dao.UserDao;
import com.github.emilg1101.lansedeniao.data.entity.CommentDto;
import com.github.emilg1101.lansedeniao.data.entity.PostDto;
import com.github.emilg1101.lansedeniao.data.entity.UserDto;
import com.github.emilg1101.lansedeniao.data.mapper.CommentMapper;
import com.github.emilg1101.lansedeniao.data.mapper.PostMapper;
import com.github.emilg1101.lansedeniao.domain.entity.Comment;
import com.github.emilg1101.lansedeniao.domain.entity.Post;
import com.github.emilg1101.lansedeniao.domain.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class PostRepositoryImpl implements PostRepository {

    @Autowired
    private PostDao postDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private LikeDao likeDao;

    @Autowired
    private CommentDao commentDao;

    @Override
    public List<Post> getPostsByUserId(long userId) {
        Optional<List<PostDto>> postDtoList = postDao.getPostsByUserId(userId);
        List<Post> posts = new ArrayList<>();
        Optional<UserDto> userDto = userDao.getUserById(userId);
        if (postDtoList.isPresent()) {
            for (PostDto postDto : postDtoList.get()) {
                userDto.ifPresent(userDto1 -> posts.add(new PostMapper().map(postDto, userDto1, commentDao.getCommentByPostId(postDto.id).get())));
            }
        }
        return posts;
    }

    @Override
    public Post addPost(long userId, String text) {
        Optional<UserDto> userDto = userDao.getUserById(userId);
        Optional<PostDto> postDto = postDao.addPost(userId, text);
        if (userDto.isPresent() && postDto.isPresent()) {
            Optional<List<CommentDto>> commentDtoList = commentDao.getCommentByPostId(postDto.get().id);
            return new PostMapper().map(postDto.get(), userDto.get(), commentDtoList.get());
        }
        return null;
    }

    @Override
    public boolean setLike(long postId, long userId) {
        if (likeDao.isLiked(postId, userId)) {
            return likeDao.removeLike(postId, userId);
        } else {
            return likeDao.setLike(postId, userId).isPresent();
        }
    }

    @Override
    public Comment addComment(long postId, long userId, String text) {
        Optional<CommentDto> commentDto = commentDao.addComment(postId, userId, text);
        if (commentDto.isPresent()) {
            return new CommentMapper().map(commentDto.get());
        }
        return null;
    }
}
