package lansedeniao.presentation;

import emilg1101.application.Application;
import emilg1101.application.ConsoleApplication;
import lansedeniao.presentation.command.HelpCommand;
import lansedeniao.presentation.command.LoginCommand;
import lansedeniao.presentation.command.LogoutCommand;
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
        addCommand("?", new HelpCommand());
        addCommand("/login <username> <password>", new LoginCommand());
        addCommand("/logout", new LogoutCommand());
    }
}
