package emilg1101.application.commands;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandReader {

    private Scanner scanner;
    private Map<String, CommandData> commandSet;
    private CommandListener commandListener;

    public CommandReader() {
        scanner = new Scanner(System.in);
        commandSet = new HashMap<>();
    }

    public void addCommand(String template, Command commandListener) {
        String command = extractCommand(template);
        CommandData commandData = new CommandData(template, commandListener);
        commandSet.put(command, commandData);
    }

    public void removeCommand(String command) {
        commandSet.remove(command);
    }

    public void setCommandListener(CommandListener commandListener) {
        this.commandListener = commandListener;
    }

    public void listen() throws CommandNotFoundException, CommandInvalidArgumentsException {
        String line;
        while (true) {
            line = scanner.nextLine();
            if (line.isEmpty()) continue;
            CommandData commandData = getCommandData(line);
            if (commandData != null) {
                List<String> keys = getKeys(commandData.template);
                Map<String, String> values = getValues(commandData.template, line, keys);
                if (keys.size() == values.size()) {
                    commandData.command.execute(new Arguments(values));
                    if (commandListener != null) {
                        commandListener.onCommand(commandData, new Arguments(values));
                    }
                } else {
                    throw new CommandInvalidArgumentsException(commandData);
                }
            } else {
                throw new CommandNotFoundException();
            }
        }
    }

    private Map<String, String> getValues(String template, String line, List<String> keys) {
        Map<String, String> map = new HashMap<>();
        String regex = template;
        for (String key : keys) {
            regex = regex.replace("<" + key + ">", "(.*?)");
        }
        regex = "^" + regex + "$";
        Matcher matcher = Pattern.compile(regex, Pattern.DOTALL).matcher(line);
        if (matcher.find() && matcher.groupCount() == keys.size()) {
            for (int i = 0; i < keys.size(); i++) {
                map.put(keys.get(i), matcher.group(i + 1));
            }
        }
        return map;
    }

    private CommandData getCommandData(String commandLine) {
        String[] data = commandLine.split(" ");
        if (data.length > 1 && commandSet.containsKey(data[0] + " " + data[1])) {
            return commandSet.get(data[0] + " " + data[1]);
        }
        return commandSet.getOrDefault(data[0], null);
    }

    private String extractCommand(String commandTemplate) {
        String[] data = commandTemplate.split(" ");
        String command = "";
        if (data.length > 1 && !data[0].contains("<") && !data[1].contains("<")) {
            command = data[0] + " " + data[1];
        } else if (!data[0].contains("<")) {
            command = data[0];
        }
        return command;
    }

    private List<String> getKeys(String line) {
        List<String> list = new ArrayList<>();
        Matcher matcher = Pattern.compile("( <(.*?)>)", Pattern.DOTALL).matcher(line);
        while (matcher.find()) {
            list.add(matcher.group(2));
        }
        return list;
    }

    public class CommandData {
        String template;
        Command command;

        CommandData(String template, Command command) {
            this.template = template;
            this.command = command;
        }

        public String getTemplate() {
            return template;
        }

        public Command getCommand() {
            return command;
        }
    }
}