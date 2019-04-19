package com.github.emilg1101.lansedeniao.presentation.view;

import com.github.emilg1101.lansedeniao.presentation.base.MvpView;
import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;

public interface LoginView extends MvpView {

    void showAuthError();

    void loggedInError();

    void showProfile(ProfileModel profileModel);
}
