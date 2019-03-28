package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.entity.User;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.presenter.ProfilePresenter;
import lansedeniao.presentation.printer.ProfilePrinter;
import lansedeniao.presentation.view.ProfileView;

import java.time.Instant;
import java.util.Date;

public class ProfileCommand implements Command, ProfileView {


    //TODO kogda emil napishet case

    ProfilePresenter profilePresenter = new ProfilePresenter();

    @Override
    public void execute(Arguments arguments) {
        profilePresenter.bind(this);
        profilePresenter.GetProfile(arguments.getString("username"));
    }

    @Override
    public void showProfile(ProfileModel profileModel) {
        new ProfilePrinter().print(profileModel);
    }

    @Override
    public void userNotFoundException() {
        System.out.println("User not found");
    }
}
