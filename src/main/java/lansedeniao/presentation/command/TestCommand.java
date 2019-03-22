package lansedeniao.presentation.command;

import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;

public class TestCommand implements Command {

    private ConsoleApplication consoleApplication;

    private Command test2;
    private Command test3;

    private int s = 0;

    public TestCommand(ConsoleApplication consoleApplication) {
        this.consoleApplication = consoleApplication;
        consoleApplication.setCommandListener((commandData, arguments) -> {
            if (!commandData.getCommand().equals(test2) && !commandData.getCommand().equals(test3) && !commandData.getCommand().equals(this)) {
                consoleApplication.removeCommand("/test2");
                consoleApplication.removeCommand("/test3");
            }
        });
    }

    @Override
    public void execute(Arguments arguments) {

        test2 = arguments1 -> System.out.println("test2");
        test3 = arguments12 -> {
            System.out.println(String.valueOf(s));
            s++;
        };

        consoleApplication.addCommand("/test2", test2);
        consoleApplication.addCommand("/test3", test3);
    }
}
