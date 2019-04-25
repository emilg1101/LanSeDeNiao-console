package lansedeniao.data.repository;

import lansedeniao.data.database.dao.CommentDao;
import lansedeniao.data.database.dao.LikeDao;
import lansedeniao.data.database.dao.PostDao;
import lansedeniao.data.database.dao.UserDao;
import lansedeniao.data.database.provider.DaoProvider;
import lansedeniao.data.database.dto.CommentDto;
import lansedeniao.data.database.dto.PostDto;
import lansedeniao.data.database.dto.UserDto;
import lansedeniao.data.mapper.CommentMapper;
import lansedeniao.data.mapper.PostMapper;
import lansedeniao.domain.entity.Comment;
import lansedeniao.domain.entity.Post;
import lansedeniao.domain.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {

    private PostDao postDao = DaoProvider.providePostDao();
    private UserDao userDao = DaoProvider.provideUserDao();
    private LikeDao likeDao = DaoProvider.provideLikeDao();
    private CommentDao commentDao = DaoProvider.provideCommentDao();

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
