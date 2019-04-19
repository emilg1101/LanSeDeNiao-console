package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;
import com.github.emilg1101.lansedeniao.presentation.presenter.ProfilePresenter;
import com.github.emilg1101.lansedeniao.presentation.printer.ProfilePrinter;
import com.github.emilg1101.lansedeniao.presentation.view.ProfileView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyProfileCommand implements Command, ProfileView {

    @Autowired
    private ProfilePresenter profilePresenter;

    @Override
    public void execute(Arguments arguments) {
        profilePresenter.bind(this);
        profilePresenter.getProfile(null);
    }

    @Override
    public void showProfile(ProfileModel profileModel) {
        new ProfilePrinter().print(profileModel);
    }

    @Override
    public void userNotFoundException() {
        System.out.println("User not found");
    }

    @Override
    public void userNotLoggedInException() {
        System.out.println("You are not logged in!");
    }
}
