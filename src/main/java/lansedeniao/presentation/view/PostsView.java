package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.CommentsModel;
import lansedeniao.presentation.model.PostModel;

public interface PostsView extends View {

    void showPost(PostModel postModel);

    void showComments(CommentsModel commentsModel);

    void noPostsError();

    void userNotFoundError();

    void userNotLoggedInError();

    void addCommentError();
}
