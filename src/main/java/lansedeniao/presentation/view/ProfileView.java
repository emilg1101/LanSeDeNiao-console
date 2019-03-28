package lansedeniao.presentation.view;

import lansedeniao.presentation.base.View;
import lansedeniao.presentation.model.ProfileModel;

public interface ProfileView extends View {

    void showProfile(ProfileModel profileModel);

    void userNotFoundException();
}
