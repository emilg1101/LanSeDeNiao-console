package lansedeniao.data.repository;

import lansedeniao.data.dao.LikeDao;
import lansedeniao.data.dao.PostDao;
import lansedeniao.data.dao.UserDao;
import lansedeniao.data.dao.provider.DaoProvider;
import lansedeniao.data.entity.PostDto;
import lansedeniao.data.entity.UserDto;
import lansedeniao.data.mapper.PostMapper;
import lansedeniao.domain.entity.Post;
import lansedeniao.domain.repository.PostRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepositoryImpl implements PostRepository {

    private PostDao postDao = DaoProvider.providePostDao();
    private UserDao userDao = DaoProvider.provideUserDao();
    private LikeDao likeDao = DaoProvider.provideLikeDao();

    @Override
    public List<Post> getPostsByUserId(long userId) {
        Optional<List<PostDto>> postDtoList = postDao.getPostsByUserId(userId);
        List<Post> posts = new ArrayList<>();
        Optional<UserDto> userDto = userDao.getUserById(userId);
        if (postDtoList.isPresent()) {
            for (PostDto postDto : postDtoList.get()) {
                userDto.ifPresent(userDto1 -> posts.add(new PostMapper().map(postDto, userDto1)));
            }
        }
        return posts;
    }

    @Override
    public Post addPost(long userId, String text) {
        Optional<UserDto> userDto = userDao.getUserById(userId);
        Optional<PostDto> postDto = postDao.addPost(userId, text);
        if (userDto.isPresent() && postDto.isPresent()) {
            return new PostMapper().map(postDto.get(), userDto.get());
        }
        return null;
    }

    @Override
    public boolean setLike(long userId, long postId) {
        return likeDao.setLike(postId, userId).isPresent();
    }
}
