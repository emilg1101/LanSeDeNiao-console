package lansedeniao.presentation.presenter;

import lansedeniao.domain.exception.AddPostException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.AddPostUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.view.AddPostView;

public class AddPostPresenter extends Presenter<AddPostView> {

    private AddPostUseCase addPostUseCase = new AddPostUseCase();

    public void addPost(String text) {

        if (text.length() > 30)
            getView().lengthException();
        try {
            addPostUseCase.addPost(text);
        } catch (
                UserNotLoggedInException e) {
                    getView().loggedInError();
        } catch (AddPostException e) {
            getView().wtfError();
        }
    }
}
