package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.printer.HelpPrinter;

public class HelpCommand implements Command {

    @Override
    public void execute(Arguments arguments) {
        new HelpPrinter().print();
    }
}
