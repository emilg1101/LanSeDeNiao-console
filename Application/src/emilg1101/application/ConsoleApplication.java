package emilg1101.application;

import emilg1101.application.commands.*;
import emilg1101.application.logging.Log;
import emilg1101.application.property.PropertyLoader;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ConsoleApplication implements Application {

    private static final String LOGGING_FORMAT = "java.lansedeniao.util.logging.SimpleFormatter.format";

    private CommandReader commandReader;

    private String TAG = this.getClass().getSimpleName();

    private ConsoleApplication consoleApplication;

    private CommandListener commandListener;

    public ConsoleApplication() {
        this.commandReader = new CommandReader();
        this.init(this);
        this.start();
        this.commandReader.setCommandListener((commandData, arguments) -> {
            if (commandListener != null) {
                commandListener.onCommand(commandData, arguments);
            }
        });
        try {
            this.commandReader.listen();
        } catch (CommandNotFoundException | CommandInvalidArgumentsException e) {
            onException(e);
        }
    }

    public void setCommandListener(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    private void initCommands() {

        Class<? extends ConsoleApplication> obj = consoleApplication.getClass();
        Method[] methods = obj.getDeclaredMethods();

        Arrays.stream(methods)
                .forEach(method -> {

                    Annotation annotation = method.getAnnotation(AddCommand.class);
                    AddCommand addCommand = (AddCommand) annotation;

                    if (addCommand != null) {
                        addCommand(addCommand.template(), (arguments) -> {
                            try {
                                method.invoke(consoleApplication, arguments);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                //Log.e("initCommands", e.toString());
                            }
                        });
                    }
                });
    }

    @Override
    public void init(Application application) {
        //Log.i(TAG, "init()");
        PropertyLoader propertyLoader = PropertyLoader.load(application);
        String format = propertyLoader.getProperties().getProperty(LOGGING_FORMAT, "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        System.setProperty(LOGGING_FORMAT, format);
        this.consoleApplication = (ConsoleApplication) application;
        addCommand("/exit", params -> close());
        initCommands();
    }

    @Override
    public void start() {
        //Log.i(TAG, "start()");
    }

    public void addCommand(String command, Command commandListener) {
        this.commandReader.addCommand(command, commandListener);
    }

    public void removeCommand(String command) {
        this.commandReader.removeCommand(command);
    }

    @Override
    public void close() {
        //Log.i(TAG, "close()");
        System.exit(0);
    }

    @Override
    public void onException(Exception e) {
        try {
            commandReader.listen();
        } catch (CommandNotFoundException | CommandInvalidArgumentsException e1) {
            onException(e1);
        }
    }
}