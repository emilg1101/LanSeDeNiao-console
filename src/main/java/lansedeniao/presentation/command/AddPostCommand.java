package lansedeniao.presentation.command;

import emilg1101.application.commands.Arguments;
import emilg1101.application.commands.Command;
import lansedeniao.domain.exception.UserNotLoggedInException;
import lansedeniao.domain.usecase.AddPostUseCase;

public class AddPostCommand implements Command {

    private AddPostUseCase addPostUseCase = new AddPostUseCase();

    @Override
    public void execute(Arguments arguments) {
        /*//TODO kogda emil napishet case
        new PostPrinter().print(new PostModel(
                "Vadim",
                "Hello world",
                "1234134",
                Date.from(Instant.now()),
                0,
                0));*/
        try {
            addPostUseCase.addPost(arguments.getString("text"));
        } catch (UserNotLoggedInException e) {

        }
    }
}
