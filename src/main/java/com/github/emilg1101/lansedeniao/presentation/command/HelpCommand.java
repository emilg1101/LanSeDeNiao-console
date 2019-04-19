package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.presenter.HelpPresenter;
import com.github.emilg1101.lansedeniao.presentation.printer.HelpPrinter;
import com.github.emilg1101.lansedeniao.presentation.view.HelpView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HelpCommand implements Command, HelpView {

    @Autowired
    private HelpPresenter helpPresenter;

    @Override
    public void execute(Arguments arguments) {
        helpPresenter.bind(this);
    }

    @Override
    public void show() {
        HelpPrinter.print();
    }
}
