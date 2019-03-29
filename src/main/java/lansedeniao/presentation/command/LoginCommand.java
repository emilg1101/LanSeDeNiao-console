package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import emilg1101.application.commands.annotation.AddCommand;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.presenter.LoginPresenter;
import lansedeniao.presentation.printer.ProfilePrinter;
import lansedeniao.presentation.view.LoginView;

@AddCommand(template = "/login <username> <password>")
public class LoginCommand implements Command, LoginView {

    private LoginPresenter loginPresenter = new LoginPresenter();

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
