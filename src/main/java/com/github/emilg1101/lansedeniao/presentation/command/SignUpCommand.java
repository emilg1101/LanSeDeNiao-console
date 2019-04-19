package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.presenter.SignUpPresenter;
import com.github.emilg1101.lansedeniao.presentation.printer.HelpPrinter;
import com.github.emilg1101.lansedeniao.presentation.view.SignUpView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SignUpCommand implements Command, SignUpView {

    @Autowired
    private SignUpPresenter signUpPresenter;

    @Override
    public void execute(Arguments arguments) {
        signUpPresenter.bind(this);
        signUpPresenter.signUp(
                arguments.getString("name"),
                arguments.getString("email"),
                arguments.getString("username"),
                arguments.getString("password")
        );
    }

    @Override
    public void signUp() {
        HelpPrinter.print();
    }

    @Override
    public void usernameExistError() {
        System.out.println("This username already exists!");
    }

    @Override
    public void emailValidationError() {
        System.out.println("Your email doesn't correct");
    }

    @Override
    public void passwordValidationError() {
        System.out.println("You need at least 3 letters in password");
    }

    @Override
    public void usernameValidationError() {
        System.out.println("You need at least 3 letters in username");
    }

    @Override
    public void nameValidationError() {
        System.out.println("You need at least 3 letters in name");
    }
}
