package emilg1101.application.commands;

import emilg1101.application.logging.Log;

import java.util.Map;
import java.util.Objects;

public class Arguments {

    private Map<String, String> arguments;

    public Arguments(Map<String, String> arguments) {
        this.arguments = arguments;
    }

    public String getString(String key) {
        return arguments.get(key);
    }

    public int getInt(String key) {
        try {
            return Integer.parseInt(arguments.get(key));
        } catch (NumberFormatException e) {
            Log.e("CMD", "Value <"+key+"> can not be converted into int");
            throw new NumberFormatException(e.getMessage());
        }
    }

    public boolean getBoolean(String key) {
        return Boolean.parseBoolean(arguments.get(key));
    }

    @Override
    public String toString() {
        return arguments.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Arguments arguments1 = (Arguments) o;
        return Objects.equals(arguments, arguments1.arguments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(arguments);
    }
}