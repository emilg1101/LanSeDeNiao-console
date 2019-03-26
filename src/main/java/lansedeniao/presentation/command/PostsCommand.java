package lansedeniao.presentation.command;

import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import emilg1101.application.commands.CommandReader;
import emilg1101.application.commands.CommandReceiver;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.presenter.PostsPresenter;
import lansedeniao.presentation.printer.PostPrinter;
import lansedeniao.presentation.view.PostsView;

public class PostsCommand implements Command, PostsView, CommandReceiver {

    private ConsoleApplication consoleApplication;

    private Command nextCommand;
    private Command prevCommand;
    private Command likeCommand;
    private Command commentsCommand;

    private PostsPresenter postsPresenter = new PostsPresenter();

    public PostsCommand(ConsoleApplication consoleApplication) {
        this.consoleApplication = consoleApplication;
        this.consoleApplication.registerReceiver(this);
        postsPresenter.bind(this);
    }

    @Override
    public void execute(Arguments arguments) {
        postsPresenter.loadPosts(arguments.getInt("user_id"));

        nextCommand = nextCommandArgs -> postsPresenter.nextPost();
        prevCommand = prevCommandArgs -> postsPresenter.prevPost();
        likeCommand = likeCommandArgs -> postsPresenter.like();
        commentsCommand = commentsCommandArgs -> postsPresenter.comments();

        consoleApplication.addCommand("/next", nextCommand);
        consoleApplication.addCommand("/prev", prevCommand);
        consoleApplication.addCommand("/like", likeCommand);
        consoleApplication.addCommand("/comments", commentsCommand);
    }

    @Override
    public void showPost(PostModel postModel) {
        new PostPrinter().print(postModel);
    }

    @Override
    public void noPostsError() {
        System.out.println("No posts!");
    }

    @Override
    public void userNotFoundError() {
        System.out.println("User not found!");
    }

    @Override
    public void onCommandReceive(CommandReader.CommandData commandData) {
        if (!commandData.getCommand().equals(nextCommand)
                && !commandData.getCommand().equals(prevCommand)
                && !commandData.getCommand().equals(likeCommand)
                && !commandData.getCommand().equals(commentsCommand)
                && !commandData.getCommand().equals(this)) {
            consoleApplication.removeCommand("/next");
            consoleApplication.removeCommand("/prev");
            consoleApplication.removeCommand("/like");
            consoleApplication.removeCommand("/comments");
            consoleApplication.unregisterReceiver(this);
            postsPresenter.onDestroy();
        }
    }
}
