package com.github.emilg1101.lansedeniao.presentation.view;

import com.github.emilg1101.lansedeniao.presentation.base.MvpView;
import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;

public interface ProfileView extends MvpView {

    void showProfile(ProfileModel profileModel);

    void userNotFoundException();

    void userNotLoggedInException();
}
