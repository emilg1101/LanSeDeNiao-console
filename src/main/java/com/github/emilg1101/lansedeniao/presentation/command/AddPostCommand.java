package com.github.emilg1101.lansedeniao.presentation.command;

import com.github.emilg1101.lansedeniao.presentation.model.PostModel;
import com.github.emilg1101.lansedeniao.presentation.presenter.AddPostPresenter;
import com.github.emilg1101.lansedeniao.presentation.printer.PostPrinter;
import com.github.emilg1101.lansedeniao.presentation.view.AddPostView;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AddPostCommand implements Command, AddPostView {

    @Autowired
    private AddPostPresenter addPostPresenter;

    @Override
    public void execute(Arguments arguments) {
        addPostPresenter.bind(this);
        addPostPresenter.addPost(arguments.getString("text"));
    }

    @Override
    public void showPost(PostModel postModel) {
        new PostPrinter().print(postModel);
    }

    @Override
    public void lengthException() {
        System.out.println("Maximum of text 100 symbols");
    }

    @Override
    public void loggedInError() {
        System.out.println("You are not logged in");
    }

    @Override
    public void wtfError() {
        System.out.println("Strange error");
    }
}
