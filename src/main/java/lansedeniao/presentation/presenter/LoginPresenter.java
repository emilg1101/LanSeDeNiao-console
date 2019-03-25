package lansedeniao.presentation.presenter;

import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.AuthException;
import lansedeniao.domain.exception.UserLoggedInException;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.usecase.LoginUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.view.LoginView;

public class LoginPresenter extends Presenter<LoginView> {

    private LoginUseCase loginUseCase = new LoginUseCase();

    public void login(String username, String password) {
        try {
            User loggedInUser = loginUseCase.login(username, password);
            getView().showProfile(ProfileModel.mapper(loggedInUser));
        } catch (UserNotFoundException | AuthException e) {
            getView().showAuthError();
        } catch (UserLoggedInException e) {
            getView().loggedInError();
        }
    }
}
