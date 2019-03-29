package lansedeniao.presentation.presenter;

import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.GetProfileUseCase;
import lansedeniao.presentation.base.Presenter;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.view.ProfileView;

public class ProfilePresenter extends Presenter<ProfileView> {

    private GetProfileUseCase getProfileUseCase = new GetProfileUseCase();

    public void getProfile(String username) {
        try {
            User user = getProfileUseCase.getProfile(username);
            getView().showProfile(ProfileModel.mapper(user));
        } catch (UserNotFoundException e) {
            getView().userNotFoundException();
        } catch (UserNotLoggedInException e) {
            getView().userNotLoggedInException();
        }
    }
}
