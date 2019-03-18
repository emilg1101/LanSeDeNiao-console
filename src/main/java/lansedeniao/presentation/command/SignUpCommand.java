package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.usecase.SignUpUseCase;
import lansedeniao.presentation.printer.HelpPrinter;

public class SignUpCommand implements Command {

    private SignUpUseCase signUpUseCase = new SignUpUseCase();

    @Override
    public void execute(Arguments arguments) {
        //TODO kogda sdelaet emil, output help printer
        new HelpPrinter().print();
    }
}
