package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.ProfileModel;

public interface LoginView extends View {

    void showAuthError();

    void loggedInError();

    void showProfile(ProfileModel profileModel);
}
