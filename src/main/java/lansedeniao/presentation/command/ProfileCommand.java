package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.model.ProfileModel;
import lansedeniao.presentation.printer.ProfilePrinter;

import java.time.Instant;
import java.util.Date;

public class ProfileCommand implements Command {


    //TODO kogda emil napishet case

    @Override
    public void execute(Arguments arguments) {
        new ProfilePrinter().print(
                new ProfileModel(
                        "213",
                        "23",
                        "123",
                        Date.from(Instant.now()),
                        Date.from(Instant.now()),
                        1,
                        0,
                        "123",
                        1));
    }
}
