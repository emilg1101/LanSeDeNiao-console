package presentation;

import domain.entity.User;
import domain.exception.AuthException;
import domain.exception.UserNotFoundException;
import domain.usecase.LoginUseCase;
import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.AddCommand;
import emilg1101.application.commands.Arguments;
import util.DbUtil;

import java.sql.Connection;

public class Main extends ConsoleApplication {

    private User loggedInUser;

    public static void main(String[] args) {
        Connection connection = DbUtil.getConnection();
        new Main();
    }

    @AddCommand(template = "/login <username> <password>")
    public void login(Arguments arguments) {
        if (loggedInUser != null) {
            System.out.println("You already logged in!");
            return;
        }

        LoginUseCase loginUseCase = new LoginUseCase();

        try {
            User loggedInUser = loginUseCase.login(arguments.getString("username"), arguments.getString("password"));
            System.out.println(loggedInUser.toString());
            this.loggedInUser = loggedInUser;
        } catch (UserNotFoundException | AuthException e) {
            System.out.println("Wrong username or password!");
        }
    }

    @AddCommand(template = "/logout")
    public void logout(Arguments arguments) {
        if (loggedInUser == null) {
            System.out.println("You are not logged in");
        } else {
            loggedInUser = null;
            System.out.println("Logout successful");
        }
    }
}
