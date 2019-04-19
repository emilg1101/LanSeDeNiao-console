package com.github.emilg1101.lansedeniao.presentation.view;

import com.github.emilg1101.lansedeniao.presentation.base.MvpView;

public interface SignUpView extends MvpView {

    void signUp();

    void usernameExistError();

    void emailValidationError();

    void passwordValidationError();

    void usernameValidationError();

    void nameValidationError();
}
