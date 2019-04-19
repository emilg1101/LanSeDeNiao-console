package com.github.emilg1101.lansedeniao.presentation.presenter;

import com.github.emilg1101.lansedeniao.domain.entity.User;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotFoundException;
import com.github.emilg1101.lansedeniao.domain.exception.UserNotLoggedInException;
import com.github.emilg1101.lansedeniao.domain.usecase.GetProfileUseCase;
import com.github.emilg1101.lansedeniao.presentation.base.MvpPresenter;
import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;
import com.github.emilg1101.lansedeniao.presentation.view.ProfileView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfilePresenter extends MvpPresenter<ProfileView> {

    @Autowired
    private GetProfileUseCase getProfileUseCase;

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
