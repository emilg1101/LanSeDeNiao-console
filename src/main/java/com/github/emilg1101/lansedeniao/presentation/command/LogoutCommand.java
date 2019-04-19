package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.presenter.LogoutPresenter;
import com.github.emilg1101.lansedeniao.presentation.view.LogoutView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LogoutCommand implements Command, LogoutView {

    @Autowired
    private LogoutPresenter logoutPresenter;

    @Override
    public void execute(Arguments arguments) {
        logoutPresenter.bind(this);
    }

    @Override
    public void logoutSuccess() {
        System.out.println("You are logged out!");
    }

    @Override
    public void logoutError() {
        System.out.println("You are not logged in!");
    }
}
