package lansedeniao.presentation.presenter;

import lansedeniao.domain.entity.Post;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.usecase.UserPostsUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.view.PostsView;

import java.util.List;

public class PostsPresenter extends Presenter<PostsView> {

    private UserPostsUseCase userPostsUseCase = new UserPostsUseCase();

    private int postPosition = 0;

    private List<Post> posts;

    public void loadPosts(long userId) {
        try {
            posts = userPostsUseCase.getPosts(userId);
            if (posts.size() > 0) {
                showPost();
            } else {
                getView().noPostsError();
            }
        } catch (UserNotFoundException e) {
            posts = null;
            getView().userNotFoundError();
        }
    }

    public void nextPost() {
        postPosition++;
        showPost();
    }

    public void prevPost() {
        postPosition--;
        showPost();
    }

    public void like() {

    }

    public void comments() {

    }

    private void showPost() {
        if (posts == null) {
            getView().userNotFoundError();
        } else {
            if (postPosition == posts.size()) postPosition = 0;
            if (postPosition < 0) postPosition = posts.size() - 1;
            getView().showPost(PostModel.mapper(posts.get(postPosition)));
        }
    }

    @Override
    public void onDestroy() {
        postPosition = 0;
        posts = null;
    }
}
