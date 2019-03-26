package lansedeniao.presentation;

import emilg1101.application.Application;
import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.CommandInvalidArgumentsException;
import emilg1101.application.commands.CommandNotFoundException;
import lansedeniao.presentation.command.*;
import lansedeniao.presentation.printer.StartPrinter;

public class Main extends ConsoleApplication {

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void init(Application application) {
        super.init(application);
        addCommand("/help", new HelpCommand());
        addCommand("/login <username> <password>", new LoginCommand());
        addCommand("/logout", new LogoutCommand());

        addCommand("/signup <name> <email> <username> <password>", new SignUpCommand());

        addCommand("/addpost <postname> <text>", new AddPostCommand());
        addCommand("/myprofile", new MyProfileCommand());
        addCommand("/profile <username>", new ProfileCommand());
       // addCommand("/posts", new OpenPostCommand());
        //addCommand("/next", new NextPostCommand());
        addCommand("/previous", new PreviousPostCommand());
        addCommand("/comments", new CommentsCommand());
        addCommand("/test", new TestCommand(this));
        addCommand("/posts <user_id>", new PostsCommand(this));
    }

    @Override
    public void start() {
        new StartPrinter().print();
    }

    @Override
    public void onException(Exception e) {
        if (e instanceof CommandNotFoundException) {
            System.out.println("Command not found!");
        } else if (e instanceof CommandInvalidArgumentsException) {
            System.out.println("Arguments entered incorrectly. Try \"" + ((CommandInvalidArgumentsException) e).getCommandData().getTemplate() + "\".");
        }
        super.onException(e);
    }
}
