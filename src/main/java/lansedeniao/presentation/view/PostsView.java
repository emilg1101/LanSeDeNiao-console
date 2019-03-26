package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.PostModel;

public interface PostsView extends View {

    void showPost(PostModel postModel);

    void noPostsError();

    void userNotFoundError();
}
