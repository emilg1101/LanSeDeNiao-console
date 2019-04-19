package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.usecase.LogoutUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.view.LogoutView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutPresenter extends MvpPresenter<LogoutView> {

    @Autowired
    private LogoutUseCase logoutUseCase;

    @Override
    public void onFirstAttach() {
        try {
            logoutUseCase.logout();
            getView().logoutSuccess();
        } catch (UserNotLoggedInException e) {
            getView().logoutError();
        }
    }
}
