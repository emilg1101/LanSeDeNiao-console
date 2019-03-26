package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.exception.*;
import lansedeniao.domain.usecase.SignUpUseCase;
import lansedeniao.presentation.presenter.SignUpPresenter;
import lansedeniao.presentation.printer.HelpPrinter;
import lansedeniao.presentation.view.SignUpView;

public class SignUpCommand implements Command, SignUpView {

    private SignUpPresenter signUpPresenter = new SignUpPresenter();

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
        HelpPrinter helpPrinter = new HelpPrinter();
        helpPrinter.print();
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
