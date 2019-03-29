package lansedeniao.presentation.presenter;

import lansedeniao.domain.entity.Post;
import lansedeniao.domain.exception.AddPostException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.AddPostUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.view.AddPostView;

public class AddPostPresenter extends Presenter<AddPostView> {

    private AddPostUseCase addPostUseCase = new AddPostUseCase();

    public void addPost(String text) {
        if (text.length() > 30) {
            getView().lengthException();
            return;
        }
        try {
            Post post = addPostUseCase.addPost(text);
            getView().showPost(PostModel.mapper(post));
        } catch (UserNotLoggedInException e) {
            getView().loggedInError();
        } catch (AddPostException e) {
            getView().wtfError();
        }
    }
}
