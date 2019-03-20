package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.printer.PostPrinter;

import java.time.Instant;
import java.util.Date;

public class PreviousPostCommand implements Command {

    @Override
    public void execute(Arguments arguments)
    {

        //TODO kogda emil napishet case
        new PostPrinter().print(new PostModel(
                "Vadim",
                "Hello world",
                "12314",
                Date.from(Instant.now()),
                0,
                0));
    }
}
