package emilg1101.application.commands;

public interface CommandReceiver {
    void onCommandReceive(CommandReader.CommandData commandData);
}
