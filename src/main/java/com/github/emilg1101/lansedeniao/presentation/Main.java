package com.github.emilg1101.lansedeniao.presentation;

import com.github.emilg1101.lansedeniao.config.MyConfig;
import com.github.emilg1101.lansedeniao.presentation.command.*;
import com.github.emilg1101.lansedeniao.presentation.printer.StartPrinter;
import emilg1101.application.Application;
import emilg1101.application.ConsoleApplication;
import emilg1101.application.commands.CommandInvalidArgumentsException;
import emilg1101.application.commands.CommandNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main extends ConsoleApplication {

    private ApplicationContext context;

    public static void main(String[] args) {
        new Main();
    }

    @Override
    public void start() {
        new StartPrinter().print();
    }

    @Override
    public void init(Application application) {
        super.init(application);
        context = new AnnotationConfigApplicationContext(MyConfig.class);

        addCommand("/addPost <text>", context.getBean(AddPostCommand.class));
        addCommand("/help", context.getBean(HelpCommand.class));
        addCommand("/login <username> <password>", context.getBean(LoginCommand.class));
        addCommand("/logout", context.getBean(LogoutCommand.class));
        addCommand("/myProfile", context.getBean(MyProfileCommand.class));
        addCommand("/posts <username>", context.getBean(PostsCommand.class).setConsoleApplication(this));
        addCommand("/profile <username>", context.getBean(ProfileCommand.class));
        addCommand("/signup <name> <email> <username> <password>", context.getBean(SignUpCommand.class));
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
