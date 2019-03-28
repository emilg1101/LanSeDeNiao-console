package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.presentation.model.CommentsModel;
import lansedeniao.presentation.presenter.CommentsPresenter;
import lansedeniao.presentation.view.CommentsView;

public class CommentsCommand implements Command, CommentsView {

    CommentsPresenter commentsPresenter = new CommentsPresenter();

    @Override
    public void execute(Arguments arguments) {
        commentsPresenter.bind(this);
        //TODO Command
    }

    @Override
    public void getComments(CommentsModel commentsModel) {
        commentsPresenter.GetComments(commentsModel);
    }

    @Override
    public void postExistError() {
        System.out.println("Post doesn't exist");
    }
}
