package lansedeniao.presentation.command;

import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.presenter.TestPresenter;
import lansedeniao.presentation.view.TestView;

public class TestCommand implements Command, TestView {

    private ConsoleApplication consoleApplication;

    private Command test2;
    private Command test3;

    private TestPresenter testPresenter = new TestPresenter();

    public TestCommand(ConsoleApplication consoleApplication) {
        this.consoleApplication = consoleApplication;
        this.consoleApplication.setCommandListener((commandData, arguments) -> {
            if (!commandData.getCommand().equals(test2) && !commandData.getCommand().equals(test3) && !commandData.getCommand().equals(this)) {
                consoleApplication.removeCommand("/test2");
                consoleApplication.removeCommand("/test3");
            }
        });
        testPresenter.bind(this);
    }

    @Override
    public void execute(Arguments arguments) {

        test2 = arguments1 -> testPresenter.onTest2Command();
        test3 = arguments12 -> testPresenter.onTest3Command();

        consoleApplication.addCommand("/test2", test2);
        consoleApplication.addCommand("/test3", test3);
    }

    @Override
    public void test2(String string) {
        System.out.println(string);
    }

    @Override
    public void test3(int count) {
        System.out.println(String.valueOf(count));
    }
}
