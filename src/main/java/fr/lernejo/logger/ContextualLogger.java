package fr.lernejo.logger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class ContextualLogger implements Logger{
    public Logger delegateLogger;
    public String callerClass;
    public ContextualLogger(Logger logger, String className){
        this.delegateLogger = logger;
        this.callerClass = className;
    }

    @Override
    public void log(String message) {
        delegateLogger.log(LocalDateTime
            .now()
            .format(DateTimeFormatter.ofPattern("yyyy:MM:dd HH:mm:ss.SSS"))
            + " " + callerClass + " > " + message);
    }
}
