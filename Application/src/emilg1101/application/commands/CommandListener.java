package emilg1101.application.commands;

public interface CommandListener {

    void onCommand(CommandReader.CommandData commandData, Arguments arguments);
}
