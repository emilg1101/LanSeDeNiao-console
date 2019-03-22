package emilg1101.application.commands;

public class CommandInvalidArgumentsException extends Exception {

    private CommandReader.CommandData commandData;

    public CommandInvalidArgumentsException(CommandReader.CommandData commandData) {
        this.commandData = commandData;
    }

    public CommandReader.CommandData getCommandData() {
        return commandData;
    }
}
