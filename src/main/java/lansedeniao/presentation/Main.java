package lansedeniao.presentation;

import emilg1101.application.Application;
import emilg1101.application.ConsoleApplication;
import lansedeniao.presentation.command.*;
import lansedeniao.presentation.printer.StartPrinter;
import lansedeniao.util.DbUtil;

import java.sql.Connection;

public class Main extends ConsoleApplication {

    public static void main(String[] args) {
        Connection connection = DbUtil.getConnection();
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
        addCommand("/posts", new OpenPostCommand());
        addCommand("/next", new NextPostCommand());
        addCommand("/previous", new PreviousPostCommand());
        addCommand("/comments", new CommentsCommand());
    }

    @Override
    public void start() {
        new StartPrinter().print();
    }
}
