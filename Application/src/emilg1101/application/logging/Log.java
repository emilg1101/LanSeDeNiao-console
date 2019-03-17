package emilg1101.application.logging;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class Log {

    private static Logger logger = Logger.getLogger("emilg1101/application");

    //DEBUG
    public static void d(String tag, String msg) {
        print(Level.FINER, tag, msg);
    }

    //INFO
    public static void i(String tag, String msg) {
        print(Level.INFO, tag, msg);
    }

    //WARNING
    public static void w(String tag, String msg) {
        print(Level.WARNING, tag, msg);
    }

    //ERROR
    public static void e(String tag, String msg) {
        print(Level.SEVERE, tag, msg);
    }

    private static void print(Level level, String tag, String message) {
        logger.log(level, "["+tag+"]: "+message);
    }
}
