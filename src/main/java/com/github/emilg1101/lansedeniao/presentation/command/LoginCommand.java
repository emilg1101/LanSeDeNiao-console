package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.model.ProfileModel;
import com.github.emilg1101.lansedeniao.presentation.presenter.LoginPresenter;
import com.github.emilg1101.lansedeniao.presentation.printer.ProfilePrinter;
import com.github.emilg1101.lansedeniao.presentation.view.LoginView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginCommand implements Command, LoginView {

    private LoginPresenter loginPresenter;

    @Autowired
    public void setLoginPresenter(LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    public void execute(Arguments arguments) {
        loginPresenter.bind(this);
        loginPresenter.login(arguments.getString("username"), arguments.getString("password"));
    }

    @Override
    public void showAuthError() {
        System.out.println("Wrong username or password!");
    }

    @Override
    public void loggedInError() {
        System.out.println("You already logged in!");
    }

    @Override
    public void showProfile(ProfileModel profileModel) {
        new ProfilePrinter().print(profileModel);
    }
}
