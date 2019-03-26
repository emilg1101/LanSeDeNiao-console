package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.presenter.LogoutPresenter;
import lansedeniao.presentation.view.LogoutView;

public class LogoutCommand implements Command, LogoutView {

    private LogoutPresenter logoutPresenter = new LogoutPresenter();

    @Override
    public void execute(Arguments arguments) {
        logoutPresenter.bind(this);
        logoutPresenter.logout();
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
