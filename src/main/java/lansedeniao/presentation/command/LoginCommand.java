package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.entity.User;
import lansedeniao.domain.exception.AuthException;
import lansedeniao.domain.exception.UserLoggedInException;
import lansedeniao.domain.exception.UserNotFoundException;
import lansedeniao.domain.usecase.LoginUseCase;
import lansedeniao.presentation.model.UserModel;
import lansedeniao.presentation.printer.LoginPrinter;

public class LoginCommand implements Command {

    private LoginUseCase loginUseCase = new LoginUseCase();

    @Override
    public void execute(Arguments arguments) {
        try {
            User loggedInUser = loginUseCase.login(arguments.getString("username"), arguments.getString("password"));
            new LoginPrinter().print(UserModel.mapper(loggedInUser));
        } catch (UserNotFoundException | AuthException e) {
            System.out.println("Wrong username or password!");
        } catch (UserLoggedInException e) {
            System.out.println("You already logged in!");
        }
    }
}
