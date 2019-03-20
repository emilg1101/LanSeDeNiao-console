package lansedeniao.presentation.command;

import com.sun.org.apache.xpath.internal.Arg;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.printer.PostPrinter;

import java.time.Instant;
import java.util.Date;

public class OpenPostCommand implements Command {

    @Override
    public void execute(Arguments arguments)
    {

        //TODO kogda emil napishet case
        new PostPrinter().print(new PostModel(
                "Vadim",
                "Hello world",
                "123",
                Date.from(Instant.now()),
                0,
                0));
    }
}
