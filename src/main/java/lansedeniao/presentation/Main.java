package lansedeniao.presentation;

import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.CommandInvalidArgumentsException;
import emilg1101.application.commands.CommandNotFoundException;
import lansedeniao.presentation.printer.StartPrinter;

public class Main extends ConsoleApplication {

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void start() {
        new StartPrinter().print();
    }

    @Override
    public void onException(Exception e) {
        if (e instanceof CommandNotFoundException) {
            System.out.println("Command not found!");
        } else if (e instanceof CommandInvalidArgumentsException) {
            System.out.println("Arguments entered incorrectly. Try \"" + ((CommandInvalidArgumentsException) e).getCommandData().getTemplate() + "\".");
        }
        super.onException(e);
    }
}
