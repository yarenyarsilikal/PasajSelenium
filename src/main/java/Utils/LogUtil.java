package Utils;


import org.apache.log4j.Logger;

public class LogUtil {

    private final static Logger log = Logger.getLogger(Logger.class.getName());

    public enum LogType {
        INFO,
        DEBUG,
        ERROR,
        FATAL
    }

    public static void log(Object message, LogType logType, String className) {
        message = logType.toString() + " " + message.toString() + " " + className;
        logMessage(message, logType);

    }

    public static void log(Object message, LogType logType, String className, Exception e) {
        message = logType.toString() + " " + message.toString() + Constants.ERROR + e + " " + className;
        logMessage(message, logType);
    }

    public static void logMessage(Object message, LogType logType) {
        switch (logType) {
            case FATAL:
                log.fatal(message);
                break;
            case ERROR:
                log.error(message);
                break;
            case DEBUG:
                log.debug(message);
                break;
            case INFO:
                log.info(message);
                break;

        }
    }



}
