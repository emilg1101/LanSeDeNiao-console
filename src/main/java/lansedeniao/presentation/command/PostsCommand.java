package lansedeniao.presentation.command;

import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.entity.Post;
import lansedeniao.domain.usecase.UserPostsUseCase;
import lansedeniao.presentation.model.PostModel;
import lansedeniao.presentation.printer.PostPrinter;

import java.util.List;

public class PostsCommand implements Command {

    private ConsoleApplication consoleApplication;

    private Command nextCommand;
    private Command prevCommand;
    private Command likeCommand;
    private Command commentsCommand;

    private UserPostsUseCase userPostsUseCase = new UserPostsUseCase();

    private List<Post> posts;
    private int postPosition = 0;

    public PostsCommand(ConsoleApplication consoleApplication) {
        this.consoleApplication = consoleApplication;
       /* this.consoleApplication.setCommandListener((commandData, arguments) -> {
            if (!commandData.getCommand().equals(nextCommand)
                    && !commandData.getCommand().equals(prevCommand)
                    && !commandData.getCommand().equals(likeCommand)
                    && !commandData.getCommand().equals(commentsCommand)
                    && !commandData.getCommand().equals(this)) {
                consoleApplication.removeCommand("/next");
                consoleApplication.removeCommand("/prev");
                consoleApplication.removeCommand("/like");
                consoleApplication.removeCommand("/comments");
                postPosition = 0;
                posts = null;
            }
        });*/
    }

    @Override
    public void execute(Arguments arguments) {

        posts = userPostsUseCase.getPosts(arguments.getInt("user_id"));
        if (posts.size() > 0) {
            new PostPrinter().print(PostModel.mapper(posts.get(postPosition)));
        }

        nextCommand = arguments1 -> {
            postPosition++;
            if (postPosition == posts.size()) postPosition = 0;
            new PostPrinter().print(PostModel.mapper(posts.get(postPosition)));
        };

        prevCommand = arguments12 -> {
            postPosition--;
            if (postPosition < 0) postPosition = posts.size() - 1;
            new PostPrinter().print(PostModel.mapper(posts.get(postPosition)));
        };

        likeCommand = new Command() {
            @Override
            public void execute(Arguments arguments) {

            }
        };

        commentsCommand = new Command() {
            @Override
            public void execute(Arguments arguments) {

            }
        };

        consoleApplication.addCommand("/next", nextCommand);
        consoleApplication.addCommand("/prev", prevCommand);
        consoleApplication.addCommand("/like", likeCommand);
        consoleApplication.addCommand("/comments", commentsCommand);
    }
}
