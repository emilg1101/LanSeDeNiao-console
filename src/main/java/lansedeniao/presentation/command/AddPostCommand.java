package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import emilg1101.application.commands.annotation.AddCommand;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.presenter.AddPostPresenter;
import lansedeniao.presentation.printer.PostPrinter;
import lansedeniao.presentation.view.AddPostView;

@AddCommand(template = "/addPost <text>")
public class AddPostCommand implements Command, AddPostView {

    private AddPostPresenter addPostPresenter = new AddPostPresenter();

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
