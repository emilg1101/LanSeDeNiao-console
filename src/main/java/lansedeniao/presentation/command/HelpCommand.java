package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.presenter.HelpPresenter;
import lansedeniao.presentation.printer.HelpPrinter;
import lansedeniao.presentation.view.HelpView;

public class HelpCommand implements Command, HelpView {

    private HelpPresenter helpPresenter = new HelpPresenter();

    @Override
    public void execute(Arguments arguments) {
        helpPresenter.bind(this);
    }

    @Override
    public void show() {
        HelpPrinter.print();
    }
}
