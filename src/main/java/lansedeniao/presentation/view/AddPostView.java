package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.PostModel;

public interface AddPostView extends View {

    void showPost(PostModel postModel);

    void lengthException();

    void loggedInError();

    void wtfError();
}
