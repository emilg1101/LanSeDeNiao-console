package lansedeniao.presentation.presenter;

import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.LogoutUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.view.LogoutView;

public class LogoutPresenter extends Presenter<LogoutView> {

    private LogoutUseCase logoutUseCase = new LogoutUseCase();

    public void logout()
    {
        try {
            logoutUseCase.logout();
            getView().Logout();
        } catch (UserNotLoggedInException e) {
            getView().LogoutError();
        }
    }
}
