package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import emilg1101.application.commands.annotation.AddCommand;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.presenter.ProfilePresenter;
import lansedeniao.presentation.printer.ProfilePrinter;
import lansedeniao.presentation.view.ProfileView;

@AddCommand(template = "/profile <username>")
public class ProfileCommand implements Command, ProfileView {

    private ProfilePresenter profilePresenter = new ProfilePresenter();

    @Override
    public void execute(Arguments arguments) {
        profilePresenter.bind(this);
        profilePresenter.getProfile(arguments.getString("username"));
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
