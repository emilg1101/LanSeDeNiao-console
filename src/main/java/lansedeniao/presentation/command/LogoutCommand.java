package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.LogoutUseCase;

public class LogoutCommand implements Command {

    private LogoutUseCase logoutUseCase = new LogoutUseCase();

    @Override
    public void execute(Arguments arguments) {
        try {
            logoutUseCase.logout();
            System.out.println("Logout successful!");
        } catch (UserNotLoggedInException e) {
            System.out.println("You are not logged in!");
        }
    }
}
