package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.AuthException;
import com.github.emilg1101.lansedeniao.domain.exception.UserLoggedInException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.usecase.LoginUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;
import com.github.emilg1101.lansedeniao.presentation.view.LoginView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPresenter extends MvpPresenter<LoginView> {

    @Autowired
    private LoginUseCase loginUseCase;

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
